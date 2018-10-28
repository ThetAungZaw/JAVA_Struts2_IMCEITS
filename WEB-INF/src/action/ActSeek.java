package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import service.*;

public class ActSeek extends ActionSupport {

	private UploadFile uploadfile;
	private Question question;
	private Language language;
	private User user;
	private List<Language> list;
	private List<Question> listq;
	private List<Answer> list_answer;
	private Answer answer;	
	private Integer QuestionID;
	private int load_more_count=0;
	private Long all_q_count=0l;
	private int currentLanguageID;
	
	
	public int getCurrentLanguageID() {
		return currentLanguageID;
	}

	public void setCurrentLanguageID(int currentLanguageID) {
		this.currentLanguageID = currentLanguageID;
	}

	public String select(){	
		
		ServletActionContext.getServletContext().setAttribute("selectedLink", "seek");
		user = (User) ServletActionContext.getServletContext().getAttribute("login_User");
		
		DBSeek dbseek = new DBSeek();
		
		if(language == null)
		{
			load_more_count=1;
			language = dbseek.FunRetrieveLanguage(true);	
		}
			
		else
		{
			load_more_count++;
			language = dbseek.FunRetrieveByLanguageID(language.getLanguageID());
		}		
		
		
		if (language != null) {		
			FunFillData();
		}
		return SUCCESS;
	}
	
	private void FunFillData()
	{
		
		//language//
		DBSeek dbseek = new DBSeek();
		list = dbseek.FunGetLanguageList();
		listq = dbseek.FunGetQuestionList(language.getLanguageID(),load_more_count);		
		list_answer = dbseek.FunRetrieve_by_questionlist(language.getLanguageID()); 
		all_q_count = dbseek.FunCountAllQList(language.getLanguageID());
		ServletActionContext.getServletContext().setAttribute("all_q_count", all_q_count);
		
		currentLanguageID = language.getLanguageID();
	}

	public String selectq() {
		if (language != null) {	
			
			FunFillData();		
		}
		return SUCCESS;
	}

	public String saveQuestiontable() {
		
		if(uploadfile != null)		
		{
			question.setImageFileName(FunUploadImage(false));
		}
		DBSeek dbseek = new DBSeek();
		question.setLanguage(language);		
		
		User _loginUser = (User) ServletActionContext.getServletContext().getAttribute("login_User");
						
		question.setUser(_loginUser);
				
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY ");
		Date date=new Date();		
		
		question.setQuestionDate(dateFormat.format(date).toString());
		
		
		
		dbseek.FunSaveQuestionTable(question);

		FunFillData();
		
		question.setTitle("");
		question.setDetailDescription("");
		
		return SUCCESS;

	}
	
	public void validateSaveanswer()
	{
		System.err.println("enter validate save answer method");
		ServletActionContext.getServletContext().setAttribute("process_QuestionID", QuestionID);
		FunFillData();//fill data in validate method also//
		System.err.println("leave validate save answer method");
	}
	
	public void validateSaveQuestiontable()
	{
		FunFillData();	//fill data in validate method also//	
	}

	public String saveanswer()

	{
		DBSeek dbseek = new DBSeek();
		
		User _loginUser = (User) ServletActionContext.getServletContext().getAttribute("login_User");
		ServletActionContext.getServletContext().getAttribute("login_User");
		
		answer.setUser(_loginUser);
		question = new Question();
		question.setQuestionID(QuestionID);
		
		answer.setQuestion(question);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY ");
		Date date=new Date();		
		
		answer.setAnswerDate(dateFormat.format(date).toString());
		
		
		dbseek.FunSaveAnswer(answer);
		
		list_answer = dbseek.FunGetAnswerList(question.getQuestionID());
		list = dbseek.FunGetLanguageList();
		listq = dbseek.FunGetQuestionList(language.getLanguageID(),load_more_count);
		
		return SUCCESS;
	}
	
	
	private String FunUploadImage(boolean editLanguage)
	{
		
		//create a new file within specified directory in which uploaded file will be copied
		//define new file path and name of file //
		String _fileName = uploadfile.getImageFileName();
		int _indexOfExtension =_fileName.lastIndexOf('.');
		String _extensionName = _fileName.substring(_indexOfExtension);
		
		//get file path//
		String p=ServletActionContext.getServletContext().getRealPath("/");
		
		//define file name with extension//
		
		int _prefixName = 0;
		if(editLanguage)
		{
			_prefixName = question.getQuestionID();
		}
		else 
		{	//new language
			DBQuestion db =new DBQuestion();
			_prefixName = db.FunRetrieveLastPrimaryKeyID() +1;	
		}
		String _newFileName = _prefixName + _extensionName;
		
		
		String _newFilePath = p +"\\upload_image\\question\\"+_newFileName;
		File file=new File(_newFilePath);
		
		//get the file uploaded by user
		File uploadedFile=uploadfile.getImage();
		
		
		//use commons IO to Copy the uploadedFile to the new file			
		try {
			System.out.println("4");
			FileUtils.copyFile(uploadedFile,file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("new file path"+ _newFilePath);
		return ("/SoftSeekSharing/upload_image/question/"+ _newFileName); // eg. 1.png or 2.jpg
			
	}

	public UploadFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(UploadFile uploadfile) {
		this.uploadfile = uploadfile;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Language> getList() {
		return list;
	}

	public void setList(List<Language> list) {
		this.list = list;
	}

	public List<Question> getListq() {
		return listq;
	}

	public void setListq(List<Question> listq) {
		this.listq = listq;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public List<Answer> getList_answer() {
		return list_answer;
	}

	public void setList_answer(List<Answer> list_answer) {
		this.list_answer = list_answer;
	}
	public Integer getQuestionID() {
		return QuestionID;
	}

	public Integer getLoad_more_count() {
		return load_more_count;
	}

	public void setLoad_more_count(Integer load_more_count) {
		this.load_more_count = load_more_count;
	}

	public void setQuestionID(Integer questionID) {
		QuestionID = questionID;
	}

	public void setLoad_more_count(int load_more_count) {
		this.load_more_count = load_more_count;
	}

	public Long getAll_q_count() {
		return all_q_count;
	}

	public void setAll_q_count(Long all_q_count) {
		this.all_q_count = all_q_count;
	}

}

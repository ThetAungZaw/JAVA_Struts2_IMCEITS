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

public class seekcomblie extends ActionSupport {

	private UploadFile uploadfile;
	private Question question;
	private Language language;
	private User user;
	private List<Language> list;
	private List<Question> listq;
	private Answer answer;
	private List<Answer> list_answer;

	
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

	public String select(){
		
		user = (User) ServletActionContext.getServletContext().getAttribute("login_User");
		DBLanguage db1 = new DBLanguage();		
		language = db1.FunRetrieve(true);
		if (language != null) {
			
			FunFillData();
		}
		return SUCCESS;
	}
	
	private void FunFillData()
	{
		
		System.err.println("enter selct question ");
		System.err.println("enter selct question " + language);
		
		System.err.println("enter selct question " + language.getLanguageID());
		
		//language//
		DBLanguage db1 = new DBLanguage();	
		list = db1.select();
		System.err.println("after select language ");
		
		DBQuestion db = new DBQuestion();
		listq = db.selectquestion(language.getLanguageID());
		
		System.err.println("enter selct question " + listq);
		
		DBAnswer dbAns = new DBAnswer();			
		list_answer = dbAns.FunRetrieve_by_questionlist(language.getLanguageID()); 
		
		System.err.println("enter selct question " + list_answer);
		
		
	}

	public String selectq() {
		
		
		System.err.println("enter selct q ");
		
					
		if (language != null) {
			
			System.err.println("enter if condition ");
			
			
			FunFillData();
			
			
			
			
		}
		return SUCCESS;
	}

	public String saveQuestiontable() {
		DBLanguage db1 = new DBLanguage();
		list = db1.select();

		System.out.println("question : " + question);
		System.out.println("language id : " + language.getLanguageID());
		question.setLanguage(language);		
		
				
		question.setUser(user);
		
		

		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY ");
		Date date=new Date();		
		
		question.setQuestionDate(dateFormat.format(date).toString());

		
		
		question.setImageFileName(FunUploadImage(false));
		DBQuestion db = new DBQuestion();
		
		
		
		db.saveQuestiontable(question);

		selectq();
		System.out.println("myat min thu ");

		question.setTitle("");
		question.setDetailDescription("");
		
		return SUCCESS;

	}

	public String saveanswer()

	{
		DBLanguage db1 = new DBLanguage();
		list = db1.select();

		user = new User();
		user.setUserID(1);
		answer.setUser(user);
		System.out.println("go to question id saveanswer : " + question.getQuestionID());
		answer.setQuestion(question);

		DBAnswer db = new DBAnswer();
		db.saveanswer(answer);
		list_answer = db.selectanswer(question.getQuestionID());
		selectq();

		return SUCCESS;
	}
	
	
	private String FunUploadImage(boolean editLanguage)
	{
		System.out.println("1");
		//create a new file within specified directory in which uploaded file will be copied
		//define new file path and name of file //
		String _fileName = uploadfile.getImageFileName();
		int _indexOfExtension =_fileName.lastIndexOf('.');
		String _extensionName = _fileName.substring(_indexOfExtension);
		
		//get file path//
		String p=ServletActionContext.getServletContext().getRealPath("/");
		
		System.out.println("2");
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
		
		
		
		
		System.out.println("3");
		//get the file uploaded by user
		File uploadedFile=uploadfile.getImage();
		
		
		//use commons IO to Copy the uploadedFile to the new file			
		try {
			System.out.println("4");
			FileUtils.copyFile(uploadedFile,file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("new file path"+ _newFilePath);
		return ("/SoftSeekSharing/upload_image/question/"+ _newFileName); // eg. 1.png or 2.jpg
		
		
	}

}

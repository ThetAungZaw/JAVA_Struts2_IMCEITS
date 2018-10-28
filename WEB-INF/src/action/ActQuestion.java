
package action;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import entity.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import service.*;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
public class ActQuestion extends ActionSupport{
	
	private List<Language> language_list; 
	

	private Question question;
	private Language language;
	private List<Question> list;
	private UploadFile uploadfile;
	public UploadFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(UploadFile uploadfile) {
		this.uploadfile = uploadfile;
	}

	private User user;
	private Date date;
	
	public List<Language> getLanguage_list() {
		return language_list;
	}

	public void setLanguage_list(List<Language> language_list) {
		this.language_list = language_list;
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

	
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public List<Question> getList() {
		return list;
	}

	public void setList(List<Question> list) {
		this.list = list;
	}

	public String fill()
	{
		ServletActionContext.getServletContext().setAttribute("selectedLinkAdmin", "question");
		FunGetDatalist();
		return SUCCESS;
	}
	
	public String search()
	{
		FunFillLanguageForIndexPage();
		System.out.println("Search");
		DBQuestion db = new DBQuestion();
		list = db.FunRetrieve(language.getLanguageID(),question.getTitle());
		return SUCCESS;
	}
	
	private void FunGetDatalist()
	{
		FunFillLanguageForIndexPage();
		if(question != null)question.setTitle("");
		System.out.println("Fill mehtod");
		DBQuestion db = new DBQuestion();
		list = db.FunRetrieve();
		System.out.println(list);
	}
	
	private void FunFillLanguageForIndexPage()
	{	
		DBLanguage dblanguage = new DBLanguage();
		language_list = dblanguage.FunRetrieve();
		
		//language for All//
		Language l = new Language();
		l.setLanguageID(-1);
		l.setLanguageName("All");
		language_list.add(l);
		
		if(language == null)
		{
			language = new Language();
			language.setLanguageID(-1);
		}	
	}
	
	private String FunUploadImage(boolean editQuestion)
	{
		System.out.println("1111111111111111111111111");
		//create a new file within specified directory in which uploaded file will be copied
		//define new file path and name of file //
		String _fileName = uploadfile.getImageFileName();
		System.out.println(_fileName);
		int _indexOfExtension =_fileName.lastIndexOf('.');
		String _extensionName = _fileName.substring(_indexOfExtension);
		
		//get file path//
		String p=ServletActionContext.getServletContext().getRealPath("/");
		
		System.out.println("2");
		//define file name with extension//
		
		int _prefixName = 0;
		if(editQuestion)
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
	
	public void validateCreate()
	{
		System.err.println("shaw");
		System.err.println("language " + language);
		System.err.println("question " + question);
		System.err.println("question " + question.getTitle());
		
		if(language.getLanguageID() < 0)
		{
			addFieldError("language.LanguageID", "*");
		}
		
		FunLanguageFill();
	}
	
	public String create()
	{
		System.out.println("Create Method Start");
		
		
		if(uploadfile != null)
		question.setImageFileName(FunUploadImage(false));
		
		user=new User();
		System.out.println("UserID"+user.getUserID());
		DateFormat dateFormat=new SimpleDateFormat("dd/MM/YYYY");
		date=new Date();
		question.setQuestionDate(dateFormat.format(date).toString());
	
		user.setUserID(1);
		
		question.setUser(user);
		
		System.out.println("Language "+language);
		System.out.println("LanguageID"+language.getLanguageID());
		
		question.setLanguage(language);
	
		
		DBQuestion db = new DBQuestion();
		System.out.println("Before funsave");
		db.FunSave(question);
		System.out.println("Saved Ok");
		FunGetDatalist();
		return SUCCESS;
	}
	
	public void FunLanguageFill()
	{
		DBLanguage db = new DBLanguage();
		language_list = db.FunRetrieve();
	}
	
	public String create_preparation()
	{
		System.out.println("Create Preparation Start");
		FunLanguageFill();
//		question = new Question();
		
		System.out.println(language_list.get(0).getLanguageID());
		System.out.println(language_list.get(0).getLanguageName());
		System.out.println("LanguageList"+language_list);
		return SUCCESS;
	}
	

	
	public String delete()
	{
		user=new User();
		user.setUserID(1);
		question.setUser(user);
		System.out.println("Delete function start");
		
		System.out.println("question title"+question.getTitle());
		DBQuestion db = new DBQuestion();
		db.FunDelete(question);
		FunGetDatalist();
		return SUCCESS;
	}
	
	public String execute()
	{
		return SUCCESS;
	}
	
//	public void validate()
//	{
//		/*if(question != null)
//		{
//			if(question.getTitle().equals(""))
//				addFieldError("question.Title","Define question title...!");
//		}*/
//	}
		
}


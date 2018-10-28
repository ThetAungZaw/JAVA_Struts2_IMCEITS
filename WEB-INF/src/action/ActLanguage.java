	
package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import service.*;

import java.io.*;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class ActLanguage extends ActionSupport{
	
	private Language language;
	private List<Language> list;
	private UploadFile uploadfile;	
	
	
	public UploadFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(UploadFile uploadfile) {
		this.uploadfile = uploadfile;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	
	public List<Language> getList() {
		return list;
	}

	public void setList(List<Language> list) {
		this.list = list;
	}

	public String fill()
	{
		ServletActionContext.getServletContext().setAttribute("selectedLink", "software");
		ServletActionContext.getServletContext().setAttribute("selectedLinkAdmin", "language");
		FunGetDataList();
		return SUCCESS;
	}
	
	public String search()
	{
		System.out.println("Search");
		DBLanguage db = new DBLanguage();
		list = db.FunRetrieve(language.getLanguageName());		
		return SUCCESS;
	}
	
	private void FunGetDataList()
	{
		User _loginUser = (User) ServletActionContext.getServletContext().getAttribute("login_User");
		System.out.println("In act_language class <<login_User Object>> is : " + _loginUser);
		
		if(language != null)language.setLanguageName("");		
		System.out.println("Fill Method");
		DBLanguage db = new DBLanguage();
		list = db.FunRetrieve();
		System.out.println(list);
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
			_prefixName = language.getLanguageID();
		}
		else 
		{	//new language
			DBLanguage db =new DBLanguage();
			_prefixName = db.FunRetrieveLastPrimaryKeyID() +1;	
		}
		String _newFileName = _prefixName + _extensionName;
		
		
		String _newFilePath = p +"\\upload_image\\language\\"+_newFileName;
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
		return ("/SoftSeekSharing/upload_image/language/"+ _newFileName); // eg. 1.png or 2.jpg
		
		
	}
	
	public String create()
	{
		if(uploadfile != null)	
		language.setLogoName(FunUploadImage(false));
		
		DBLanguage db = new DBLanguage();
		db.FunSave(language);
		System.out.println("created!");
		FunGetDataList();
		return SUCCESS;
	}
	
	public String edit()
	{	
		System.out.println("upload file " + uploadfile);
		if(uploadfile != null)				
		{
			System.out.println("after null");
		
			language.setLogoName(FunUploadImage(true));
			System.out.println("set 2");
		}
		
		System.out.println("logo name : " + language.getLogoName());
		DBLanguage db = new DBLanguage();
		db.FunUpdate(language);
		FunGetDataList();
		return SUCCESS;
	}
	
	public String delete()
	{
//		System.out.println("uploadfile" + uploadfile);
//		System.out.println("uploadfile image" + uploadfile.getImageFileName());
//		if(!uploadfile.equals(null) || !uploadfile.getImageFileName().equals(""))				
//		language.setLogoName(FunUploadImage());
		
		//System.out.println("l name " + language.getLanguageName());
		DBLanguage db = new DBLanguage();
		db.FunDelete(language);
		FunGetDataList();
		return SUCCESS;
	}

	public String execute()
	{
		return SUCCESS;
	}
	
//	public void validate()
//	{	
//		if(language != null)
//		{
//			if(language.getLanguageName().equals(""))
//				addFieldError("language.LanguageName","Define language name....!");	
//		}
//		
//	}
		
}


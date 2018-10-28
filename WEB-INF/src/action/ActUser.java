
package action;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import entity.*;


import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import service.*;

public class ActUser extends ActionSupport {

	private User user;
	private List<User> list;
	private UploadFile uploadfile;

	public UploadFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(UploadFile uploadfile) {
		this.uploadfile = uploadfile;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public String fill() {
		
		ServletActionContext.getServletContext().setAttribute("selectedLinkAdmin", "member");
		FunGetDataList();
		return SUCCESS;
	}

	public String search() {
		System.out.println("Search");
		DBUser db = new DBUser();
		list = db.FunRetrieve(user.getUserName());
		int _size = list.size();
		while(list.iterator().hasNext() && _size > 0)
		{
			_size--;
			if(list.iterator().next().getUserID()==1)
			{
				list.remove(list.iterator().next());
				break;
			}
		}
		return SUCCESS;
	}

	private void FunGetDataList() {
		if (user != null)
			user.setUserName("");
		System.out.println("Fill Method");
		DBUser db = new DBUser();
		list = db.FunRetrieve();
		while(list.iterator().hasNext())
		{
			if(list.iterator().next().getUserID()==1)
			{
				list.remove(list.iterator().next());
				break;
			}
		}
		
		
		System.out.println(list);
	}

	private String FunUploadImage(boolean editData) {
		System.out.println("1");
		// create a new file within specified directory in which uploaded file
		// will be copied
		// define new file path and name of file //
		System.out.println("uploadfile object is " + uploadfile);
		System.out.println("uploadfile object image file name is " + uploadfile.getImageFileName());
		
		String _fileName = uploadfile.getImageFileName();
		int _indexOfExtension = _fileName.lastIndexOf('.');
		String _extensionName = _fileName.substring(_indexOfExtension);

		// get file path//
		String p = ServletActionContext.getServletContext().getRealPath("/");

		System.out.println("2");
		// define file name with extension//

		int _prefixName = 0;
		if (editData) {
			_prefixName = user.getUserID();
		} else { // new user
			DBUser db = new DBUser();
			_prefixName = db.FunRetrieveLastPrimaryKeyID() + 1;
		}
		String _newFileName = _prefixName + _extensionName;

		String _newFilePath = p + "\\upload_image\\user\\" + _newFileName;
		File file = new File(_newFilePath);

		System.out.println("3");
		// get the file uploaded by user
		File uploadedFile = uploadfile.getImage();

		// use commons IO to Copy the uploadedFile to the new file
		try {
			System.out.println("4");
			FileUtils.copyFile(uploadedFile, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("new file path" + _newFilePath);
		return ("/SoftSeekSharing/upload_image/user/" + _newFileName); // eg.
																			// 1.png
																			// or
																			// 2.jpg

	}
	
	public void createValidate()
	{
//		Date _dob =null;
//		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
//		try {
//			_dob = df.parse(user.getDOB());
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Date sDate = Date.parse("1/1/1900"); 
//		
		
	}

	public String create() {

		if(uploadfile != null)
		{
			user.setProfilePictureName(FunUploadImage(false));	
		}
		else
		{
			//for default image //
			user.setProfilePictureName("/SoftSeekSharing/upload_image/user/0.png");
		}
		
		DBUser db = new DBUser();

		db.FunSave(user);
		FunPutLoginUserSession(user);
		return SUCCESS;
	}

	public String edit() {
		
	
		if(uploadfile != null)				
		{
			System.out.println("after null");
		
			user.setProfilePictureName(FunUploadImage(true));
			System.out.println("set 2");
		}
		
		System.out.println("profile picture name " + user.getProfilePictureName());
		DBUser db = new DBUser();
		db.FunUpdate(user);
		ServletActionContext.getServletContext().setAttribute("login_User", user);		
		return SUCCESS;
	}

	public String delete() {
		System.out.println("l name " + user.getUserName());
		DBUser db = new DBUser();
		db.FunDelete(user);
		FunGetDataList();
		return SUCCESS;
	}

	public String execute() {
		return SUCCESS;
	}

	public String login_check() {

		if ((user.getUserName().equals("Admin") || user.getUserName().equals("admin"))
				&& user.getPassword().equals("123")) {
			return "SuccessAdmin";
		} else {
			DBUser db = new DBUser();
			User _matchUser = db.FunRetrieve(user);

			if (_matchUser != null) {
				FunPutLoginUserSession(_matchUser);
				// use it'value from masterpage.jsp and ActLanguage.java
				// put null value when user logout <--> in this class of
				// user_logout() method
				return SUCCESS;
			} 
			else
			{
				addActionError("*Username and password is not match!");
				return INPUT;
						
			}

		}

	}
	
	private void FunPutLoginUserSession(User _matchUser)
	{
		ServletActionContext.getServletContext().setAttribute("login_User", _matchUser);
	}
	
	

	public String user_logout() {
		ServletActionContext.getServletContext().setAttribute("login_User", null);
		ServletActionContext.getServletContext().setAttribute("selectedLink", "masterhome");
		return SUCCESS;
	}

	public String user_retrieve(){
	
		System.out.println("Retrieve Success");		
		user = (User) ServletActionContext.getServletContext().getAttribute("login_User");
		
		
		//make inactive link active hover//
		ServletActionContext.getServletContext().setAttribute("selectedLink", "Inactive");
		
		return SUCCESS;
	}
	
	 public void validateCreate()
	 { 
		 DBUser db =new DBUser();
		 if( db.FunRetrieveDuplicatedName(user.getUserName()))
			 addFieldError("user.UserName","Duplicated");
		 
	 }
	 
	 
	 public void validateLogin_check()
	 {
		 if(user.getUserName().equals(""))
		 {
			 addFieldError("user.UserName","*");
		 }
		 
		 if(user.getPassword().equals(""))
		 {
			 addFieldError("user.Password","*");
		 }
	 }
	 
	 public String loginFun()
	 {
		 ServletActionContext.getServletContext().setAttribute("selectedLink", "login");
		 return SUCCESS;
	 }

}

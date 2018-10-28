
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

public class ActPostData extends ActionSupport{
	
	private PostData postdata;
	private List<PostData> list;
	private Date date;
	private UploadFile uploadfile;
//	private User user;
	
	
	public PostData getPostdata() {
		return postdata;
	}

	public void setPostdata(PostData postdata) {
		this.postdata = postdata;
	}
	
	public List<PostData> getList() {
		return list;
	}

	public void setList(List<PostData> list) {
		this.list = list;
	}
	
	
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UploadFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(UploadFile uploadfile) {
		this.uploadfile = uploadfile;
	}

	public String fill()
	{
		ServletActionContext.getServletContext().setAttribute("selectedLinkAdmin", "post");
		FunGetDataList();
		return SUCCESS;
	}
	
	public String search()
	{
		System.out.println("Search");
		DBPostData db = new DBPostData();
		list = db.FunRetrieve(postdata.getTitle());		
		return SUCCESS;
	}
	
	private void FunGetDataList()
	{
		if(postdata != null)postdata.setTitle("");		
		System.out.println("Fill Method");
		DBPostData db = new DBPostData();
		list = db.FunRetrieve();
		System.out.println("retrieve");
		System.out.println(list);
	}
	
	private String FunUploadImage(boolean editPostdata)
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
		if(editPostdata)
		{
			_prefixName = postdata.getPostID();
		}
		else 
		{	//new language
			DBPostData db =new DBPostData();
			_prefixName = db.FunRetrieveLastPrimaryKeyID() +1;	
		}
		String _newFileName = _prefixName + _extensionName;
		
		
		String _newFilePath = p +"\\upload_image\\postdata\\"+_newFileName;
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
		return ("/SoftSeekSharing/upload_image/postdata/"+ _newFileName); // eg. 1.png or 2.jpg
		
		
	}
	
	public String create()
	{
		if(uploadfile != null)
		{
			postdata.setImageFileName(FunUploadImage(false));	
		}		
		
		date=new Date();
		
		DateFormat dateFormat=new SimpleDateFormat("dd/MM/YYYY");
		postdata.setPostingDate(dateFormat.format(date).toString());
		User user=new User();
		user.setUserID(1);
		System.out.println("User"+user.getUserID());
		DBPostData db = new DBPostData();
		postdata.setUser(user);
		db.FunSave(postdata);
		System.out.println("Post"+postdata);
		FunGetDataList();
		
		return SUCCESS;
	}
	
//	public String edit()
//	{		
//		DBPostData db = new DBPostData();
//		db.FunUpdate(postdata);
//		FunGetDataList();
//		return SUCCESS; 
//	}
	
	public String delete()
	{	
		
		/*System.out.println("l name " + postdata.getTitle());*/
		System.out.println("uuuu");
	    DBPostData db = new DBPostData();
		db.FunDelete(postdata);
		System.out.println("delete!");
		FunGetDataList();
		System.out.println("list deleted");    
		return SUCCESS;
	}

	
	public String execute()
	{
		return SUCCESS;
	}
	
//	public void validate()
//	{
//		/*if(postdata != null)
//			{
//				if(postdata.getTitle().equals(""))
//					addFieldError("postdata.Title","Define post title....!");	
//			}*/
//	}
		
}


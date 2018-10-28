		
package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import service.*;

public class ActPostingComment extends ActionSupport{
	
	private PostingComment postingcomment;
	private List<PostingComment> list;
	private PostData postdata;
	private int postid;
	private Date date;
	
	
	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public PostingComment getPostingcomment() {
		return postingcomment;
	}

	public void setPostingcomment(PostingComment postingcomment) {
		this.postingcomment = postingcomment;
	}
	
	public List<PostingComment> getList() {
		return list;
	}

	public void setList(List<PostingComment> list) {
		this.list = list;
	}
	
	public PostData getPostdata() {
		return postdata;
	}

	public void setPostdata(PostData postdata) {
		this.postdata = postdata;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String fill()
	{
		
		FunGetDataList();
		return SUCCESS;
	}
	
	public String search()
	{
		System.out.println("Search");
		DBPostingComment db = new DBPostingComment();
		System.out.println("s1");
		list = db.FunRetrieve(postingcomment.getComment(), postid);	
		System.out.println("s2");
		return SUCCESS;
	}
	
	private void FunGetDataList()
	{
		System.out.println("p ... 1 " + postid);
		if(postingcomment != null)postingcomment.setComment("");		
		
		DBPostingComment db = new DBPostingComment();
		
		list = db.FunRetrieveByPostID(postid);
		
		System.out.println("yy : "+ postid);
		System.out.println(list);
	}
	
	public String createpreparation()
	{
		System.out.println("....1. ..." + postid);		
		return SUCCESS;
	}
	
	public String create()
	{
		date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("dd/MM/YYYY");
		postingcomment.setCommentDate(dateFormat.format(date).toString());
		
		User user=new User();
		user.setUserID(1);
		
		System.out.println("11");
		DBPostingComment db = new DBPostingComment();
		postingcomment.setUser(user);
	
		System.out.println("shaw ....");
		System.out.println("postid  " + postid);
		
		
		postdata = new PostData();
		postdata.setPostID(postid);
		postingcomment.setPostdata(postdata);
		System.out.println("POSTD  "+postdata);
		System.out.println("22");
		db.FunSave(postingcomment);
		System.out.println("55");
		FunGetDataList();
		return SUCCESS;
	}
	
	public String edit()
	{		
		DBPostingComment db = new DBPostingComment();
		db.FunUpdate(postingcomment);
		FunGetDataList();
		return SUCCESS;
	}
	
	public String delete()
	{
		//System.out.println("l name " + postingcomment.getComment());
//		postdata = new PostData();
//		postdata.setPostID(postid);
//		postingcomment.setPostdata(postdata);
		DBPostingComment db = new DBPostingComment();
		db.FunDelete(postingcomment);
		FunGetDataList();
		return SUCCESS;
	}

	
	public String execute()
	{
		return SUCCESS;
	}
	
	public void validate()
	{
		/*if(postingcomment != null)
			{
				if(postingcomment.getComment().equals(""))
					addFieldError("postingcomment.Comment","Define comment....!");	
			}*/
	}
		
}


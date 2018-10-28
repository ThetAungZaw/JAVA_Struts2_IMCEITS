	
package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import service.DBSuggestion;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.struts2.ServletActionContext;


public class ActSuggestion extends ActionSupport{
	
	private Suggestion suggestion;
	private User user;
	private Date date;
	
	private List<Suggestion> list;
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Suggestion getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
	}
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Suggestion> getList() {
		return list;
	}

	public void setList(List<Suggestion> list) {
		this.list = list;
	}
	
	public String fill()
	{
		ServletActionContext.getServletContext().setAttribute("selectedLinkAdmin", "suggest");
		FunGetDataList();
		return SUCCESS;
	}
	
	public String search()
	{
		System.out.println("Search");
		DBSuggestion db = new DBSuggestion();
		System.out.println("Search1");
		list = db.FunRetrieve(suggestion.getDetailDescription());		
		return SUCCESS;
	}
	
	private void FunGetDataList()
	{
		if(suggestion != null)suggestion.setDetailDescription("");		
		System.out.println("Fill Method");
		DBSuggestion db = new DBSuggestion();
		System.out.println("aa");
		
		list = db.FunRetrieve();
		System.out.println(list);
	}
	
	public String create()
	{
		System.out.println("1");
		User _loginUser = (User) ServletActionContext.getServletContext().getAttribute("login_User");
		System.out.println("ActSuggestion user >>>>>>>>>>>>>>>>>> "+_loginUser);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY ");
		date=new Date();
		suggestion.setSuggestDate(dateFormat.format(date).toString());
		//user = new User();
		
		System.out.println("12");
		
		//user.setUserID(1);//will be used dynamically after login success!!! *shaw
		
		System.out.println("13");
		
		suggestion.setUser(_loginUser);
		
		System.out.println("14");
		
		DBSuggestion db=new DBSuggestion();
		
		System.out.println("15");
		db.FunSave(suggestion);
		suggestion.setDetailDescription("");
		//FunGetDataList();
		
		System.out.println("3");
		return SUCCESS;
	}
	
	public String edit()
	{		
		System.out.println("edit start");
		DBSuggestion db = new DBSuggestion();
		suggestion.setIsReply(true);
		db.FunUpdate(suggestion);
		FunGetDataList();
		return SUCCESS;
	}
	
	public String delete()
	{
		
		//System.out.println("l name " + suggestion.getDetailDescription());
		DBSuggestion db = new DBSuggestion();
		db.FunDelete(suggestion);
		FunGetDataList();
		return SUCCESS;
	}

	public String execute()
	{
		return SUCCESS;
	}
	
	public String funInactive()
	{
		ServletActionContext.getServletContext().setAttribute("selectedLink", "Inactive");
		return SUCCESS;
	}
	
//	public void validate()
//	{
//		/*if(suggestion != null)
//			{
//				if(suggestion.getDetailDescription().equals(""))
//					addFieldError("suggestion.DetailDescription","Define detail description....!");	
//			}*/
//	}
		
}


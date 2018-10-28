package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import service.*;

public class ActAnswer extends ActionSupport{
	
	private Answer answer;
	private List<Answer> list;
	private Question question;
	private int questionid;
	private Date date;

	public Answer getAnswer() {		
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	public List<Answer> getList() {
		return list;
	}

	public void setList(List<Answer> list) {
		this.list = list;
	}
	
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
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
		DBAnswer db = new DBAnswer();
		System.out.println("q1");
		list = db.FunRetrieve(answer.getDetailDescription(),questionid);
		System.out.println("q2");
		return SUCCESS;
	}
	
	private void FunGetDataList()
	{
		if(answer != null)answer.setDetailDescription("");
		System.out.println("Fill Method");
		DBAnswer db = new DBAnswer();
				
		System.out.println("qq");
		System.out.println("question:" +question);
		System.out.println("question "+questionid);
		
		list = db.FunRetrieveByQuestionID(questionid);
		System.out.println(list);
	}
	
	public String createpreparation()
	{
		System.out.println("...1..."+questionid);
		return SUCCESS;
	}

	public String create()
	{
		System.out.println("in create");
		date = new Date();
		DateFormat dateFormat=new SimpleDateFormat("dd/MM/YYYY");
		answer.setAnswerDate(dateFormat.format(date).toString());
		answer.setCorrect(true);
		
		User user = new User();
		user.setUserID(1);
		
		System.out.println("11");
		DBAnswer db = new DBAnswer();
		answer.setUser(user);
		
		System.out.println("user....");
		System.out.println("questionid "+questionid);
		
		question = new Question();
		question.setQuestionID(questionid);
		answer.setQuestion(question);
		System.out.println("22");
		
		db.FunSave(answer);
		System.out.println("55");
		FunGetDataList();
		return SUCCESS;
	}
	
	public String edit()
	{
		DBAnswer db = new DBAnswer();
		db.FunUpdate(answer);
		FunGetDataList();
		return SUCCESS;
	}
	
	
	public String delete()
	{
		//System.out.println("detail description" + answer.getDetailDescription());
		DBAnswer db = new DBAnswer();
		db.FunDelete(answer);
		FunGetDataList();
		return SUCCESS;
	}
	
	public String execute()
	{
		return SUCCESS;
	}
	
	public String fun_answer_delete()
	{
		System.out.println("ans id : " + answer.getAnswerID());
		System.out.println("ans desc : " + answer.getDetailDescription());
		System.out.println("question id : " + questionid);
		
		return SUCCESS;
	}
	
	
	
	public void validate()
	{
		/*if(answer != null)
		{
			if(answer.getDetailDescription().equals(""))
				addFieldError("answer.DetailDescription","Define detail description....!");
		}*/
	}
		
}


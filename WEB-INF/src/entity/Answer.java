package entity;

import javax.persistence.*;

import java.io.*;
import java.util.*;
@Entity
@Table (name="tAnswer")

public class Answer implements Serializable{
	
	@Id
	@GeneratedValue
	private int AnswerID;
	private String DetailDescription;
	private String AnswerDate;
	private boolean Correct;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QuestionID", nullable = false)
	private Question question;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", nullable = false)
	private User user;

	
	
	public boolean isCorrect() {
		return Correct;
	}

	public void setCorrect(boolean correct) {
		Correct = correct;
	}

	public int getAnswerID() {
		return AnswerID;
	}

	public void setAnswerID(int answerID) {
		AnswerID = answerID;
	}

	public String getDetailDescription() {
		return DetailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		DetailDescription = detailDescription;
	}

	

	public String getAnswerDate() {
		return AnswerDate;
	}

	public void setAnswerDate(String answerDate) {
		AnswerDate = answerDate;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
	

	
		
		
}


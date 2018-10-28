package entity;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table (name="tQuestion")

public class Question implements Serializable{
	
	@Id
	@GeneratedValue
	private int QuestionID;
	private String Title;
	private String DetailDescription;
	private String ImageFileName;
	private String QuestionDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", nullable = false)
	private User user;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LanguageID", nullable = false)
	private Language language;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Answer> answer = new HashSet<Answer>();


	public int getQuestionID() {
		return QuestionID;
	}


	public void setQuestionID(int questionID) {
		QuestionID = questionID;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public String getDetailDescription() {
		return DetailDescription;
	}


	public void setDetailDescription(String detailDescription) {
		DetailDescription = detailDescription;
	}


	


	public String getImageFileName() {
		return ImageFileName;
	}


	public void setImageFileName(String imageFileName) {
		ImageFileName = imageFileName;
	}


	


	public String getQuestionDate() {
		return QuestionDate;
	}


	public void setQuestionDate(String questionDate) {
		QuestionDate = questionDate;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Language getLanguage() {
		return language;
	}


	public void setLanguage(Language language) {
		this.language = language;
	}


	public Set<Answer> getAnswer() {
		return answer;
	}


	public void setAnswer(Set<Answer> answer) {
		this.answer = answer;
	}

			
	
	
		
}


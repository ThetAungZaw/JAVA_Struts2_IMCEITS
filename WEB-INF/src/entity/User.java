package entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table (name="tUser")

public class User implements Serializable{
	
	@Id
	@GeneratedValue
	private int UserID;
	private String UserName;
	private String Password;
	private String ProfilePictureName;
	private String Email;
	private String Gender;
	private String DOB; 
	private String Address;
	
			
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<PostData> postdata = new HashSet<PostData>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<PostingComment> postingcomment = new HashSet<PostingComment>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<PostingLike> postinglike = new HashSet<PostingLike>();
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Answer> answer = new HashSet<Answer>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Question> question = new HashSet<Question>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Suggestion> suggestion = new HashSet<Suggestion>();

	
	
	
	
	
	
	public Set<Question> getQuestion() {
		return question;
	}
	public void setQuestion(Set<Question> question) {
		this.question = question;
	}
	public Set<PostingLike> getPostinglike() {
		return postinglike;
	}
	public void setPostinglike(Set<PostingLike> postinglike) {
		this.postinglike = postinglike;
	}
	
	public Set<Suggestion> getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(Set<Suggestion> suggestion) {
		this.suggestion = suggestion;
	}
	public Set<PostingComment> getPostingcomment() {
		return postingcomment;
	}
	public void setPostingcomment(Set<PostingComment> postingcomment) {
		this.postingcomment = postingcomment;
	}
	public Set<Answer> getAnswer() {
		return answer;
	}
	public void setAnswer(Set<Answer> answer) {
		this.answer = answer;
	}
	public Set<PostData> getPostdata() {
		return postdata;
	}
	public void setPostdata(Set<PostData> postdata) {
		this.postdata = postdata;
	}	
	
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getProfilePictureName() {
		return ProfilePictureName;
	}
	public void setProfilePictureName(String profilePictureName) {
		ProfilePictureName = profilePictureName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

	
	
	
}


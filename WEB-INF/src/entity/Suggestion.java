package entity;

import javax.persistence.*;

import java.io.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table (name="tSuggestion")

public class Suggestion implements Serializable{
	
	@Id
	@GeneratedValue
	private int SuggestID;
	private String DetailDescription;
	private String SuggestDate;
	private boolean IsReply;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", nullable = false)
	private User user;
	

	
	public int getSuggestID() {
		return SuggestID;
	}


	public void setSuggestID(int suggestID) {
		SuggestID = suggestID;
	}

	public String getDetailDescription() {
		return DetailDescription;
	}


	public void setDetailDescription(String detailDescription) {
		DetailDescription = detailDescription;
	}


	public String getSuggestDate() {
		return SuggestDate;
	}


	public void setSuggestDate(String suggestDate) {
		SuggestDate = suggestDate;
	}


	public boolean isIsReply() {
		return IsReply;
	}


	public void setIsReply(boolean isReply) {
		IsReply = isReply;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}




	
}


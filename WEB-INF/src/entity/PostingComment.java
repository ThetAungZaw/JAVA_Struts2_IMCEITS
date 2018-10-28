package entity;

import javax.persistence.*;

import java.io.*;
import java.util.*;
@Entity
@Table (name="tPostingComment")

public class PostingComment implements Serializable{
	
	@Id
	@GeneratedValue
	private int CommentID;
	private String Comment;
	private String CommentDate;
		
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PostID", nullable = false)
	private PostData postdata;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", nullable = false)
	private User user;
	
	public int getCommentID() {
		return CommentID;
	}


	public void setCommentID(int commentID) {
		CommentID = commentID;
	}


	public String getComment() {
		return Comment;
	}


	public void setComment(String comment) {
		Comment = comment;
	}


	


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getCommentDate() {
		return CommentDate;
	}


	public void setCommentDate(String commentDate) {
		CommentDate = commentDate;
	}


	public PostData getPostdata() {
		return postdata;
	}


	public void setPostdata(PostData postdata) {
		this.postdata = postdata;
	}
	
	
	
		
}


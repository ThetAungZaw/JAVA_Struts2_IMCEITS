package entity;

import javax.persistence.*;

import java.io.*;
import java.util.*;
@Entity
@Table (name="tPostingLike")

public class PostingLike implements Serializable{
	
	@Id
	@GeneratedValue
	private int LikeID;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PostID", nullable = false)
	private PostData postdata;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", nullable = false)
	private User user;

	public int getLikeID() {
		return LikeID;
	}

	public void setLikeID(int likeID) {
		LikeID = likeID;
	}

	public PostData getPostdata() {
		return postdata;
	}

	public void setPostdata(PostData postdata) {
		this.postdata = postdata;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
	
	
		
}


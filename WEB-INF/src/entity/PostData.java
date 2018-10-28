package entity;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table (name="tPostData")

public class PostData implements Serializable{
	
	@Id
	@GeneratedValue
	private int PostID;
	private String Title;
	private String DetailDescription;
	private String ImageFileName;
	private String PostingDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", nullable = false)
	private User user;	
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "postdata")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<PostingComment> postingcomment = new HashSet<PostingComment>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "postdata")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<PostingLike> postinglike = new HashSet<PostingLike>();

	public int getPostID() {
		return PostID;
	}

	public void setPostID(int postID) {
		PostID = postID;
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

	

	public String getPostingDate() {
		return PostingDate;
	}

	public void setPostingDate(String postingDate) {
		PostingDate = postingDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<PostingComment> getPostingcomment() {
		return postingcomment;
	}

	public void setPostingcomment(Set<PostingComment> postingcomment) {
		this.postingcomment = postingcomment;
	}

	public Set<PostingLike> getPostinglike() {
		return postinglike;
	}

	public void setPostinglike(Set<PostingLike> postinglike) {
		this.postinglike = postinglike;
	}
			
	
	
		
}


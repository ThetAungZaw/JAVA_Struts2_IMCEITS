package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import java.io.*;
import java.util.*;
import service.*;

public class ActPostingLike extends ActionSupport{
	
	private ActPostingLike postinglike;

	public ActPostingLike getPostinglike() {
		return postinglike;
	}

	public void setPostinglike(ActPostingLike postinglike) {
		this.postinglike = postinglike;
	}
	
	public String execute()
	{
		return SUCCESS;
	}
//	
//	public void validate()
//	{
//		
//	}
}

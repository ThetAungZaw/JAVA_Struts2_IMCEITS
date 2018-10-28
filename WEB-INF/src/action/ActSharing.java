package action;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.java.swing.plaf.windows.resources.windows;
import com.sun.org.apache.regexp.internal.recompile;

import entity.PostData;
import entity.PostingComment;
import entity.PostingLike;
import entity.UploadFile;
import entity.User;
import freemarker.log._Log4jOverSLF4JTester;
import service.DBLanguage;
import service.DBPostingLike;
import service.DBSharing;

public class ActSharing extends ActionSupport {

	private PostData postdata;
	private User user;
	private PostingComment postingcomment;
	private PostingLike postinglike;
	private List<PostData> list;
	private List<PostingComment> comment_list;
	private List<PostingLike> like_list;
	private int load_more = 0;
	private long diff;
	private long diffSeconds;
	private long diffMinutes;
	private long diffHours;
	private long diffDays;
	private long diffYear;
	private String post_time;
	private Long like_count;
	private Long comment_count;
	
	private UploadFile uploadfile;
	private Integer PostID;
	
	/*
	 * HttpServletRequest request=(HttpServletRequest)
	 * ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	 */

	/* >>>>>>>>>>>>>>>>>>>> post methods <<<<<<<<<<<<<<<<<<<<<<< */

	public String fill_post() {
		
		ServletActionContext.getServletContext().setAttribute("selectedLink", "sharing");
		load_more++;
		FunGetDataList_post();
		return SUCCESS;
	}

	private void FunGetDataList_post() {
		DBSharing dbs = new DBSharing();
		list = dbs.FunRetrieve_post(load_more);
		comment_list = dbs.FunRetrieve_by_postlist(list);
		
	}
	
	public String create_post() {

		if(uploadfile != null)		
		{
			postdata.setImageFileName(FunUploadImage(false));
		}
		
		User _loginUser = (User) ServletActionContext.getServletContext().getAttribute("login_User");
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY ");
		Date date = new Date();

		postdata.setUser(_loginUser);
		postdata.setPostingDate(dateFormat.format(date).toString());

		DBSharing dbs = new DBSharing();
		dbs.FunSave_post(postdata);
		
		FunGetDataList_post();
		postdata.setDetailDescription("");
		postdata.setTitle("");

		return SUCCESS;
	}
	
	public void validateCreate_comment()
	{
		System.err.println("enter validate save answer method");
		ServletActionContext.getServletContext().setAttribute("process_PostID", PostID);
		FunGetDataList_post();//fill data in validate method also//
		System.err.println("leave validate save answer method");
	}
	
	public void validateCreate_post()
	{
		FunGetDataList_post();	//fill data in validate method also//	
	}

	public String create_comment() {
		User _loginUser = (User) ServletActionContext.getServletContext().getAttribute("login_User");
			
		postdata = new PostData();
		postdata.setPostID(PostID);

		postdata.setUser(_loginUser);
		postingcomment.setUser(_loginUser);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY ");
		Date date = new Date();

		postingcomment.setPostdata(postdata);
		postingcomment.setCommentDate(dateFormat.format(date).toString());

		DBSharing dbs = new DBSharing();
		dbs.FunSave_comment(postingcomment);

		FunGetDataList_post();
		return SUCCESS;
	}

	/* >>>>>>>>>>>>>>>>>>>> like methods <<<<<<<<<<<<<<<<<<<<<<< */
	public String create_like() {
		
		User _loginUser = (User) ServletActionContext.getServletContext().getAttribute("login_User");
		
		postdata = new PostData();
		postinglike = new PostingLike();

		DBSharing dbs = new DBSharing();
		postdata.setPostID(PostID);
		
		postdata.setUser(_loginUser);
		postinglike.setUser(_loginUser);
		postinglike.setPostdata(postdata);

		dbs.FunSave_like(postinglike);

		FunGetDataList_post();
		return SUCCESS;
	}

	/*public String ShowMinAgo(int postid) {
		DBSharing dbs = new DBSharing();
		postdate = dbs.FunReturnDate(postid);

		Date d1 = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date now = new Date();
			d1 = format.parse(postdate.toString());

			diff = now.getTime() - d1.getTime(); // in milliseconds
			diffSeconds = diff / 1000 % 60;
			diffMinutes = diff / (60 * 1000) % 60;
			diffHours = diff / (60 * 60 * 1000) % 24;
			diffDays = diff / (24 * 60 * 60 * 1000);
			diffYear = diffDays / 365;

			post_time = diffHours + " : " + diffMinutes + " : " + diffSeconds + " ";

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return post_time;
	}
*/
	public String FunCountLikeComment(int postid) {
		DBSharing dbs = new DBSharing();
		like_count = dbs.FunCountLike(postid);
		comment_count = dbs.FunCountComment(postid);
		return SUCCESS;
	}

	private String FunUploadImage(boolean editLanguage) {
		System.out.println("1");
		// create a new file within specified directory in which uploaded file
		// will be copied
		// define new file path and name of file //
		String _fileName = uploadfile.getImageFileName();
		int _indexOfExtension = _fileName.lastIndexOf('.');
		String _extensionName = _fileName.substring(_indexOfExtension);
		// get file path//
		String p = ServletActionContext.getServletContext().getRealPath("/");

		// define file name with extension//

		int _prefixName = 0;
		if (editLanguage) {
			_prefixName = postdata.getPostID();
		} else { // new languages
			DBSharing dbs = new DBSharing();
			_prefixName = dbs.FunRetrieveLastPrimaryKeyID() + 1;
		}
		String _newFileName = _prefixName + _extensionName;

		String _newFilePath = p + "\\upload_image\\postdata\\" + _newFileName;
		File file = new File(_newFilePath);

		// get the file uploaded by user
		File uploadedFile = uploadfile.getImage();

		// use commons IO to Copy the uploadedFile to the new file
		try {
			FileUtils.copyFile(uploadedFile, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ("/SoftSeekSharing/upload_image/postdata/" + _newFileName); // eg.
																			// 1.png
																			// or
																			// 2.jpg

	}

	public String execute() {
		return SUCCESS;
	}

	public PostData getPostdata() {
		return postdata;
	}

	public void setPostdata(PostData postdata) {
		this.postdata = postdata;
	}

	public List<PostData> getList() {
		return list;
	}

	public void setList(List<PostData> list) {
		this.list = list;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PostingComment> getComment_list() {
		return comment_list;
	}

	public void setComment_list(List<PostingComment> comment_list) {
		this.comment_list = comment_list;
	}

	public PostingComment getPostingcomment() {
		return postingcomment;
	}

	public void setPostingcomment(PostingComment postingcomment) {
		this.postingcomment = postingcomment;
	}

	public List<PostingLike> getLike_list() {
		return like_list;
	}

	public void setLike_list(List<PostingLike> like_list) {
		this.like_list = like_list;
	}

	public PostingLike getPostinglike() {
		return postinglike;
	}

	public void setPostinglike(PostingLike postinglike) {
		this.postinglike = postinglike;
	}

	public Integer getLoad_more() {
		return load_more;
	}

	public void setLoad_more(Integer load_more) {
		this.load_more = load_more;
	}

	public long getDiff() {
		return diff;
	}

	public Integer getPostID() {
		return PostID;
	}

	public void setPostID(Integer postID) {
		PostID = postID;
	}

	public void setDiff(long diff) {
		this.diff = diff;
	}

	public void setLoad_more(int load_more) {
		this.load_more = load_more;
	}

	public UploadFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(UploadFile uploadfile) {
		this.uploadfile = uploadfile;
	}

	public long getDiffSeconds() {
		return diffSeconds;
	}

	public void setDiffSeconds(long diffSeconds) {
		this.diffSeconds = diffSeconds;
	}
	public long getDiffMinutes() {
		return diffMinutes;
	}

	public void setDiffMinutes(long diffMinutes) {
		this.diffMinutes = diffMinutes;
	}

	public long getDiffHours() {
		return diffHours;
	}

	public void setDiffHours(long diffHours) {
		this.diffHours = diffHours;
	}

	public String getPost_time() {
		return post_time;
	}

	public void setPost_time(String post_time) {
		this.post_time = post_time;
	}

	public long getDiffDays() {
		return diffDays;
	}

	public void setDiffDays(long diffDays) {
		this.diffDays = diffDays;
	}

	public long getDiffYear() {
		return diffYear;
	}

	public void setDiffYear(long diffYear) {
		this.diffYear = diffYear;
	}

	public Long getLike_count() {
		return like_count;
	}

	public void setLike_count(Long like_count) {
		this.like_count = like_count;
	}

	public Long getComment_count() {
		return comment_count;
	}

	public void setComment_count(Long comment_count) {
		this.comment_count = comment_count;
	}

}

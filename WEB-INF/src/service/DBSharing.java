package service;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import entity.PostData;
import entity.PostingComment;
import entity.PostingLike;
import entity.Question;

public class DBSharing {
	Transaction tx=null;
	Session session=null;	
	private Integer id;	
	private Long count_like;
	private Long count_comment;
	private Date postdate;
	private Boolean disable_like;
	private Long all_post_count;
	
	
	/*<<<<<<<<<<<<<<<< post part >>>>>>>>>>>>>>>>>>>>*/ 
	
public Boolean getDisable_like() {
		return disable_like;
	}

	public void setDisable_like(Boolean disable_like) {
		this.disable_like = disable_like;
	}

public Boolean FunDisableLike(int postID, int userID) {
		
		System.out.println("post id " + postID);
		System.out.println("user id " + userID);
		
		session = HibernateUtil.getSession();
	
		
		Criteria critqq = session.createCriteria(PostData.class, "q");
		critqq.createCriteria("user", "u");
		critqq.add(Restrictions.eq("q.PostID", postID));
		PostData pd = new PostData();
		if(critqq.list().size() > 0)
			 pd = (PostData) critqq.list().get(0);
		
		
		Criteria crit = session.createCriteria(PostingLike.class,"pk");
		crit.createCriteria("user","u");
		crit.createCriteria("postdata","p");
		crit.add(Restrictions.and(Restrictions.eq("u.UserID", userID),
				Restrictions.eq("pk.postdata", pd)));
		
		System.out.println("before list " + crit.list());
		System.out.println("before list size " + crit.list().size());
		List<PostingLike> list = crit.list();

		System.out.println("list " + list);
		System.out.println("list size " + list.size());
		
		session.close();

		if (list.size() > 0)
			disable_like =  true;

		else
			disable_like =  false;

		return disable_like;
	
	//return false;
	}

	public void FunSave_post(PostData postdata)
	{
		try
		{
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx=session.beginTransaction();
			
			session.save(postdata);
						
			tx.commit();
			System.out.println("Saved!");
			
		}
		catch(Exception ex)
		{
			System.out.println("catch!");
			if(tx!=null)
				tx.rollback();
			ex.printStackTrace();		
			
		}
		finally
		{
			System.out.println("session funsave closed!");
			session.close();
		}
		
	}
	
	public List<PostData> FunRetrieve_post(int load_more_count)
	{
		System.err.println("load_more in funretrieve post >> "+load_more_count);
		session = HibernateUtil.getSession();	
		System.out.println("before List .....");
		
		Criteria crit = session.createCriteria(PostData.class);		
		crit.createCriteria("user","u"); //for connecting to user table	
		
		crit.addOrder(Order.desc("PostID"));
		crit.setMaxResults(5*load_more_count);
		List<PostData> list = crit.list();
		System.out.println("get list : " + list);
		
		session.close();
		return list;
	}
	
	
	/*<<<<<<<<<<<<<<<< comment part >>>>>>>>>>>>>>>>>>>>*/ 
	public void FunSave_comment(PostingComment postingcomment)
	{
		try
		{
			session = HibernateUtil.getSession();
			System.out.println("got session obj in posting comment........");
			tx=session.beginTransaction();
			
			session.save(postingcomment);
			System.out.println("got session.save obj........");
			
			tx.commit();
			System.out.println("Saved!");
		}
		catch(Exception ex)
		{
			System.out.println("catch!");
			if(tx!=null)
				tx.rollback();
			ex.printStackTrace();			
		}
		finally
		{
			System.out.println("session closed!");
			session.close();
		}
	}
	
	public List<PostingComment> FunRetrieve_by_postlist(List<PostData> list )
	{	
		session = HibernateUtil.getSession();		
		
		Criteria critPost = session.createCriteria(PostData.class,"p");
		critPost.createCriteria("user","u");
		List<PostData> pList = critPost.list();
		System.err.println("pList " + pList);
		
		Criteria crit = session.createCriteria(PostingComment.class,"pcmm");
		crit.createCriteria("user","u"); //for connecting to user table
		crit.createCriteria("postdata","pd");//for union join two tables
		
		crit.add(Restrictions.in("pcmm.postdata", pList));		
		crit.addOrder(Order.asc("CommentDate"));	
		System.out.println("Before adding to comment list..");
		List<PostingComment> comment_list = crit.list();
		System.out.println("After adding to comment list..");		
		
//		List<PostingComment> comment_list = null;
		session.close();
		return comment_list;
	}
	
	public Long FunCountLike(int postid){
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(PostingLike.class);
		
		crit.setProjection(Projections.rowCount());
		crit.add(Restrictions.eq("postdata.PostID",postid));
		count_like=(Long)crit.uniqueResult();
		session.close();
		
		return count_like;
	}
	/*<<<<<<<<<<<<<<<< like part >>>>>>>>>>>>>>>>>>>>*/ 
	public void FunSave_like(PostingLike postinglike)
	{
		try
		{
			session = HibernateUtil.getSession();
			tx=session.beginTransaction();
			
			session.save(postinglike);
						
			tx.commit();
			System.out.println("Saved!");
		}
		catch(Exception ex)
		{
			System.out.println("catch!");
			if(tx!=null)
				tx.rollback();
			ex.printStackTrace();			
		}
		finally
		{
			System.out.println("session closed!");
			session.close();
		}
	}
	
	
	
	public Long FunCountComment(int postid){
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(PostingComment.class);
		
		crit.setProjection(Projections.rowCount());
		crit.add(Restrictions.eq("postdata.PostID",postid));
		
		count_comment=(Long)crit.uniqueResult();
		session.close();
		
		return count_comment;
	}
	
	////////////////////////////fun for counting all post list///////////
	public Long FunCountAllPostList(){
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(PostData.class);
		
		crit.setProjection(Projections.rowCount());
			
		all_post_count=(Long)crit.uniqueResult();
		session.close();
		
		return all_post_count;
	}

	public int FunRetrieveLastPrimaryKeyID()
	{	
		session = HibernateUtil.getSession();
		
		Criteria crit = session.createCriteria(PostData.class);
		
		crit.setProjection(Projections.max("PostID"));
		
		int lastPrimaryKeyID = 0;
		try		
		{
			lastPrimaryKeyID = (int) crit.list().get(0);
		}
		catch(Exception ex)
		{
			lastPrimaryKeyID = 0;
		}
		
		
		session.close();
		return lastPrimaryKeyID;
	}
	
	public Date FunReturnDate(int postid){
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(PostData.class);
		crit.add(Restrictions.eq("postdata.PostID",postid));
		postdate=(Date) crit.list();
		
		session.close();
		return postdate;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getCount_like() {
		return count_like;
	}

	public void setCount_like(Long count_like) {
		this.count_like = count_like;
	}

	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	public Long getCount_comment() {
		return count_comment;
	}

	public void setCount_comment(Long count_comment) {
		this.count_comment = count_comment;
	}

	public Long getAll_post_count() {
		return all_post_count;
	}

	public void setAll_post_count(Long all_post_count) {
		this.all_post_count = all_post_count;
	}

	
	
}

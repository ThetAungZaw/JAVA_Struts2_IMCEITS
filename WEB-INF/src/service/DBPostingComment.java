package service;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import entity.*;

public class DBPostingComment 
{
	Transaction tx=null;
	Session session=null;	
		
	public void FunSave(PostingComment comment)
	{
		try
		{
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx=session.beginTransaction();
			System.out.println("33");
			session.save(comment);
			
			System.out.println("44");
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
	
	public void FunUpdate(PostingComment comment)
	{
		try
		{
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx=session.beginTransaction();
		
			PostingComment ent=(PostingComment)session.get(PostingComment.class, comment.getCommentID());
			ent.setComment(comment.getComment());
			ent.setCommentDate(comment.getCommentDate());
			session.update(ent);
			
			tx.commit();
			System.out.println("Updated!");
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
	
	public void FunDelete(PostingComment comment)
	{
		try
		{
			System.err.println("find out error");
			session = HibernateUtil.getSession();
			
			System.out.println("got session obj........");
			tx=session.beginTransaction();

			Criteria critPost = session.createCriteria(PostData.class,"p");
			critPost.createCriteria("user","u");
			//critPost.add(Restrictions.eq("p.PostID", postID ));	
			List<PostData> pList = critPost.list();
			System.err.println("pList " + pList);
			
			Criteria crit = session.createCriteria(PostingComment.class,"pocm");
			crit.createCriteria("user","u");
			crit.createCriteria("postdata","p");
			crit.add(Restrictions.in("pocm.postdata", pList ));
			List<PostingComment> list = crit.list();
			
			PostingComment ent =(PostingComment) session.get(PostingComment.class, comment.getCommentID());			
			session.delete(ent);			
			
			

//			
			
			//comment//
//			Criteria crit = session.createCriteria(PostingComment.class,"pocm");
//			crit.createCriteria("postdata","p");
//			crit.createCriteria("user","u");
//			crit.add(Restrictions.in("pocm.postdata", pList ));
//			crit.add(Restrictions.eq("pocm.CommentID", comment.getCommentID()));
//			List<PostingComment> list = crit.list();	
			
//			System.err.println("list.size() " + list.size());
//			if(list.size()>0)
//			{
//				PostingComment ent =(PostingComment) list.get(0);
//				session.delete(ent);	
//				System.err.println("delete on 10 56 PM ");
//			}
//			
//			
//			System.out.println("list " + list);
			
			tx.commit();
			System.out.println("Deleted!");
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
	
	public List<PostingComment> FunRetrieve()
	{	
		session = HibernateUtil.getSession();		
		Criteria crit = session.createCriteria(PostingComment.class);
		crit.createCriteria("user","u");
		crit.createCriteria("postdata","p");
		
		
		System.out.println("111");
		List<PostingComment> list = crit.list();
		session.close();
		return list;
	}
	
	public List<PostingComment> FunRetrieveByPostID(int postID)
	{			
		System.err.println("fint out error in select");
		session = HibernateUtil.getSession();
		
		Criteria critPost = session.createCriteria(PostData.class,"p");
		critPost.createCriteria("user","u");
		critPost.add(Restrictions.eq("p.PostID", postID ));	
		List<PostData> pList = critPost.list();
		System.err.println("pList " + pList);
		
		
		//comment//
		Criteria crit = session.createCriteria(PostingComment.class,"pocm");
		crit.createCriteria("postdata","p");
		crit.createCriteria("user","u");
		crit.add(Restrictions.in("pocm.postdata", pList ));
		List<PostingComment> list = crit.list();
		
		System.out.println("list " + list);
		
		session.close();
		return list;		
	}
	
	public List<PostingComment> FunRetrieve(String comment, int postID)
	{
		session = HibernateUtil.getSession();	
		Criteria critPost = session.createCriteria(PostData.class,"p");
		critPost.createCriteria("user","u");
		critPost.add(Restrictions.eq("p.PostID", postID ));	
		List<PostData> pList = critPost.list();
		System.err.println("pList " + pList);
		
		
		//comment//
		Criteria crit = session.createCriteria(PostingComment.class,"pocm");
		crit.createCriteria("postdata","p");
		crit.createCriteria("user","u");
		crit.add(Restrictions.in("pocm.postdata", pList ));
		crit.add(Restrictions.like("pocm.Comment", "%"+comment+"%"));
		List<PostingComment> list = crit.list();		
		System.out.println("list " + list);
	
		session.close();
		return list;		
	}
}	
	
	


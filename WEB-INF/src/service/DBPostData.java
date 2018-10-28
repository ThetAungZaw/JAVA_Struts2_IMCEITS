package service;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import entity.*;

public class DBPostData 
{
	Transaction tx=null;
	Session session=null;	
	
	public void FunSave(PostData postdata)
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
			System.out.println("session closed!");
			session.close();
		}
	}
	
//	public void FunUpdate(PostData postdata)
//	{
//		try
//		{
//			session = HibernateUtil.getSession();
//			System.out.println("got session obj........");
//			tx=session.beginTransaction();
//		
//			PostData ent=(PostData)session.get(PostData.class, postdata.getPostID());
//			ent.setTitle(postdata.getTitle());
//			ent.setDetailDescription(postdata.getDetailDescription());
//			ent.setImageFileName(postdata.getImageFileName());
//			ent.setPostingDate(postdata.getPostingDate());
//			session.update(ent);
//			
//			tx.commit();
//			System.out.println("Updated!");
//		}
//		catch(Exception ex)
//		{
//			System.out.println("catch!");
//			if(tx!=null)
//				tx.rollback();
//			ex.printStackTrace();			
//		}
//		finally
//		{
//			System.out.println("session closed!");
//			session.close();
//		}
//	}
	
	public void FunDelete(PostData postdata)
	{
		try
		{
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx=session.beginTransaction();

			Criteria crit = session.createCriteria(PostData.class);
			crit.createCriteria("user","u");
			System.out.println("111");
			List<PostData> list = crit.list();
			System.out.println("list"+list);
			
			PostData ent =(PostData) session.get(PostData.class, postdata.getPostID());
			System.out.println("Post id.."+postdata.getPostID());
			System.out.println("ent"+ent);
			session.delete(ent);			
			System.out.println("start......");
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
	
	public int FunRetrieveLastPrimaryKeyID()
	{	
		System.out.println("k 1");
		session = HibernateUtil.getSession();
		
		System.out.println("k 2");
		Criteria crit = session.createCriteria(PostData.class);
		
		System.out.println("k 3");
		crit.setProjection(Projections.max("PostID"));
		
		System.out.println("k 4");
		
		
		int lastPrimaryKeyID = 0;
		try		
		{
			lastPrimaryKeyID = (int) crit.list().get(0);
		}
		catch(Exception ex)
		{
			lastPrimaryKeyID = 0;
		}
		
		
		System.out.println("k 5");
		session.close();
		
		System.out.println("k 6");
		return lastPrimaryKeyID;
	}
	
	public List<PostData> FunRetrieve()
	{
		session = HibernateUtil.getSession();		
		System.out.println("Before list1...");
		Criteria crit = session.createCriteria(PostData.class);
		crit.createCriteria("user","u");
		crit.addOrder(Order.desc("PostID"));
		
		System.out.println("111");
		List<PostData> list = crit.list();
		System.out.println("222");
		session.close();
		return list;
	}
	
	public List<PostData> FunRetrieve(String title)
	{
		session = HibernateUtil.getSession();
		System.out.println("session 2");
		Criteria crit = session.createCriteria(PostData.class,"p");
		crit.createCriteria("user","u");
		crit.add(Restrictions.like("p.Title","%"+title+"%",MatchMode.ANYWHERE));
		crit.addOrder(Order.desc("PostID"));
		System.out.println("start");
		List<PostData> list = crit.list();
		System.out.println(list);
		session.close();
		return list;	
	}
}	
	
	


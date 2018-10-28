package service;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import entity.*;

public class DBSuggestion 
{
	Transaction tx=null;
	Session session=null;	
		
	public void FunSave(Suggestion suggestion)
	{
		try
		{
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx=session.beginTransaction();
			
			session.save(suggestion);
			
			
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
	
	public void FunUpdate(Suggestion suggestion)
	{
		try
		{
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx=session.beginTransaction();
			
			Criteria crit=session.createCriteria(Suggestion.class);
			crit.createCriteria("user","u");
			System.out.println("2");
			
			List<Suggestion> list = crit.list();
			
			System.out.println("33");
			Suggestion ent=(Suggestion)session.get(Suggestion.class, suggestion.getSuggestID());
			//ent.setDetailDescription(suggestion.getDetailDescription());
			ent.setIsReply(suggestion.isIsReply());
			//ent.setSuggestDate(suggestion.getSuggestDate());
			//ent.setUser(suggestion.getUser());
			System.out.println("change");
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
	
	public void FunDelete(Suggestion suggestion)
	{
		try
		{
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx=session.beginTransaction();
			
			Criteria crit=session.createCriteria(Suggestion.class);
			crit.createCriteria("user","u");
			System.out.println("2");
			List<Suggestion> list = crit.list();
			System.out.println("transaction begin");
			
			System.out.println(suggestion);
			
			Suggestion ent =(Suggestion) session.get(Suggestion.class, suggestion.getSuggestID());	
			
			System.out.println("ent");
			
			session.delete(ent);			
			
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
	
	public List<Suggestion> FunRetrieve()
	{
		System.out.println("1");
		session = HibernateUtil.getSession();	
		Criteria crit=session.createCriteria(Suggestion.class);
		crit.createCriteria("user","u");
		
		
		crit.addOrder(Order.desc("SuggestID"));		
		
		
		System.out.println("2");
		List<Suggestion> list = crit.list();
		
		System.out.println("3");
		session.close();
		
		System.out.println("1");
		return list;
	}
	public List<Suggestion> FunRetrieve(String detailDescription)
	{			
		System.out.println("Search3");
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(Suggestion.class,"suggest");
		crit.createCriteria("user","u");
		//crit.add(Restrictions.eq("description","Mouse")); //for equal//
		crit.add(Restrictions.like("suggest.DetailDescription", "%"+detailDescription+"%",MatchMode.ANYWHERE));
		crit.addOrder(Order.desc("SuggestID"));	
		
		List<Suggestion> list = crit.list();
		session.close();
		return list;		
	}
}	
	
	


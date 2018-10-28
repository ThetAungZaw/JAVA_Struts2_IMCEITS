package service;

import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import entity.*;

public class DBLanguage 
{
	Transaction tx=null;
	Session session=null;	
	
	
	public Language FunRetrieve(boolean firstRowOnly) {
		session = HibernateUtil.getSession();
		Criteria c = session.createCriteria(Language.class);
		c.setFirstResult(0);
		c.setMaxResults(1);
		List<Language> list = c.list();
		session.close();
		
		
		Language ss = new Language();
		ss.setLanguageID(0);
		ss.setLanguageName("");
		try		
		{
			ss = list.get(0);
		}
		catch(Exception ex)
		{			
		}
		
		return ss;
	}
	
	
	public List<Language> select()
	{	
		System.out.println("zz");
		session = HibernateUtil.getSession();
		
		System.out.println("zz2");
		List<Language> list = session.createCriteria(Language.class).list();
		
		System.out.println("zz3");
		session.close();
		return list;
	}
	
	public int FunRetrieveLastPrimaryKeyID()
	{	
		System.out.println("k 1");
		session = HibernateUtil.getSession();
		
		System.out.println("k 2");
		Criteria crit = session.createCriteria(Language.class);
		
		System.out.println("k 3");
		crit.setProjection(Projections.max("LanguageID"));
		
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
	
	public List<Language> FunRetrieve()
	{	
		session = HibernateUtil.getSession();		
		List<Language> list = session.createCriteria(Language.class).list();		
		
		session.close();
		return list;
	}
	
	public List<Language> FunRetrieve(String languageName)
	{			
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(Language.class);
		//crit.add(Restrictions.eq("description","Mouse")); //for equal//
		crit.add(Restrictions.like("LanguageName", "%"+languageName+"%",MatchMode.ANYWHERE));
		List<Language> list = crit.list();
		session.close();
		return list;		
	}
	
	public void FunSave(Language language)
	{
		try
		{
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx=session.beginTransaction();
			
			session.save(language);
			
			
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
	
	public void FunUpdate(Language language)
	{
		try
		{
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx=session.beginTransaction();
		
			Language ent=(Language)session.get(Language.class, language.getLanguageID());
			ent.setLanguageName(language.getLanguageName());
			ent.setLogoName(language.getLogoName());
			ent.setCanTest(language.isCanTest());
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
	
	public void FunDelete(Language language)
	{
		try
		{
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx=session.beginTransaction();

			System.out.println("language : " + language);
			System.out.println("language id : " + language.getLanguageID());
			
			Language ent =(Language) session.get(Language.class, language.getLanguageID());			
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

}	
	
	


package service;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import entity.*;

public class DBLecture 
{
	Transaction tx=null;
	Session session=null;	
		
	public void FunSave(Lecture lecture)
	{
		try
		{
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx=session.beginTransaction();
			
			
			System.out.println("lecture object : " + lecture);
			System.out.println("lecture section : " + lecture.getSection());
			System.out.println("lecture language : " + lecture.getLanguage());
			
			
			session.save(lecture);
			
			
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
	
	public void FunUpdate(Lecture lecture)
	{
		System.out.println("start fun");
		try
		{
			System.out.println("in fun");
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx=session.beginTransaction();
			//
			Criteria crit = session.createCriteria(Lecture.class);
			crit.createCriteria("language","lg");
			crit.createCriteria("section","st");
			List<Lecture> list = crit.list();
			
			
			System.out.println(lecture);
			System.out.println(lecture.getLectureID());
			System.out.println(lecture.getSection().getSectionID());
			System.out.println(lecture.getLanguage().getLanguageID());
			Lecture ent=(Lecture)session.get(Lecture.class, lecture.getLectureID());	
			
			System.out.println("asd");
			
			ent.setTitle(lecture.getTitle());
			ent.setDetailDescription(lecture.getDetailDescription());
			ent.setSampleCode(lecture.getSampleCode());
			//ent.setCreateDate(lecture.getCreateDate()); //no need to modify bcoz it's created date information
			ent.setSortAlphabet(lecture.getSortAlphabet());
			ent.setTryYourSelf(lecture.isTryYourSelf());
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
	
	public void FunDelete(Lecture lecture)
	{
		try
		{
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx=session.beginTransaction();
			//
			Criteria crit = session.createCriteria(Lecture.class);
			crit.createCriteria("language","lg");
			crit.createCriteria("section","st");
			List <Lecture> list=crit.list();

			Lecture ent =(Lecture) session.get(Lecture.class, lecture.getLectureID());			
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
	
	public List<Lecture> FunRetrieve()
	{	
		session = HibernateUtil.getSession();
		
		Criteria c = session.createCriteria(Lecture.class,"l");
		c.createCriteria("language","g");
		c.createCriteria("section","s");
		c.addOrder(Order.asc("g.LanguageID"));
		c.addOrder(Order.asc("SortAlphabet"));
		
		
		List<Lecture> list = c.list();
		
		session.close();
		return list;
	}
	
	
	
	public List<Lecture> FunRetrieve(int languageID, int sectionID)
	{	
		session = HibernateUtil.getSession();
		
		Criteria c = session.createCriteria(Lecture.class,"l");
		c.createCriteria("language","g");
		c.createCriteria("section","s");
		
		System.out.println("languageID : " + languageID);
		
		if(languageID > 0)
		c.add(Restrictions.eq("g.LanguageID", languageID));
		
		if(sectionID > 0)
		c.add(Restrictions.eq("s.SectionID", sectionID));
		
		c.addOrder(Order.asc("g.LanguageID"));
		c.addOrder(Order.asc("SortAlphabet"));
		
		List<Lecture> list = c.list();
		
		session.close();
		return list;
	}
	
	public List<Lecture> FunRetrieve(int languageID, int sectionID, String lectureTitle)
	{			
		System.err.println("lecture title is .... " + lectureTitle);
		session = HibernateUtil.getSession();
		System.out.println("session ok");
		Criteria crit = session.createCriteria(Lecture.class);
		crit.createCriteria("language","lg");
		crit.createCriteria("section","st");
		System.out.println("crit ok");
		
		if(languageID > 0)
			crit.add(Restrictions.eq("lg.LanguageID", languageID));
			
		if(sectionID > 0)
			crit.add(Restrictions.eq("st.SectionID", sectionID));
			
		//crit.add(Restrictions.eq("description","Mouse")); //for equal//
		crit.add(Restrictions.like("Title", "%"+lectureTitle+"%",MatchMode.ANYWHERE));
		
		crit.addOrder(Order.asc("lg.LanguageID"));
		crit.addOrder(Order.asc("SortAlphabet"));
		List<Lecture> list = crit.list();
		session.close();
		return list;		
	}
	
	public Lecture FunRetrieve(Integer lectureID)
	{			
		session = HibernateUtil.getSession();
		System.out.println("session ok");
		Criteria crit = session.createCriteria(Lecture.class,"lect");
		crit.createCriteria("language","lg");
		crit.createCriteria("section","st");
		System.out.println("crit ok");
		
		//crit.add(Restrictions.eq("description","Mouse")); //for equal//
		crit.add(Restrictions.eq("lect.LectureID", lectureID));
		crit.addOrder(Order.asc("lg.LanguageID"));
		crit.addOrder(Order.asc("SortAlphabet"));
		Lecture lect = (Lecture) crit.list().get(0);
		session.close();
		return lect;		
	}
}	
	
	


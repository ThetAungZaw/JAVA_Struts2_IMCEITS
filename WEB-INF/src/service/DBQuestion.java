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

public class DBQuestion {
	Transaction tx = null;
	Session session = null;
	
	
	public List<Question>selectquestion(int languageid1)
	{		
		System.out.println("1DBquestion");
		System.out.println(languageid1);
		
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(Question.class,"q");
		//crit.add(Restrictions.eq("description","Mouse")); //for equal//
		crit.createCriteria("language","l");
		crit.createCriteria("user","u");
		crit.add(Restrictions.eq("l.LanguageID",languageid1));
		
		crit.addOrder(Order.desc("QuestionID"));
		
		crit.setMaxResults(3);
		List<Question> list=crit.list();
		
		System.out.println("4");
		session.close();
		return list;		
	}
	
		public void saveQuestiontable(Question question)
	{
		try
		{
		
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx=session.beginTransaction();
			
			System.out.println("user object " + question.getUser());
			System.out.println("user object user id " + question.getUser().getUserID());
			
			System.out.println("language object " + question.getLanguage());
			System.out.println("language object language id " + question.getLanguage().getLanguageID());
			
			System.out.println("question insert database:::::"+"  "+question);
			
			session.save(question);
			
			
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

	

		
	public int FunRetrieveLastPrimaryKeyID()
	{	
		System.out.println("k 1");
		session = HibernateUtil.getSession();
		
		System.out.println("k 2");
		Criteria crit = session.createCriteria(Question.class);
		
		System.out.println("k 3");
		crit.setProjection(Projections.max("QuestionID"));
		
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

	public void FunSave(Question question) {
		try {
			System.out.println("This is funsave");
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx = session.beginTransaction();

			session.save(question);

			tx.commit();
			System.out.println("Saved!");
		} catch (Exception ex) {
			System.out.println("catch!");
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			System.out.println("session closed!");
			session.close();
		}
	}

	public void FunUpdate(Question question) {
		try {
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx = session.beginTransaction();

			Question ent = (Question) session.get(Question.class, question.getQuestionID());
			ent.setDetailDescription(question.getDetailDescription());
			ent.setImageFileName(question.getImageFileName());
			ent.setQuestionDate(question.getQuestionDate());
			ent.setTitle(question.getTitle());
			ent.setLanguage(question.getLanguage());
			ent.setUser(question.getUser());
			session.update(ent);

			tx.commit();
			System.out.println("Updated!");
		} catch (Exception ex) {
			System.out.println("catch!");
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			System.out.println("session closed!");
			session.close();
		}
	}

	public void FunDelete(Question question) {
		try {
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx = session.beginTransaction();
			
			Criteria crit=session.createCriteria(Question.class);
			crit.createCriteria("user","u");
			crit.createCriteria("language","l");
			List<Question> list = crit.list();
			
			Question ent = (Question) session.get(Question.class, question.getQuestionID());
			System.out.println("db");
			System.out.println(question);
			System.out.println(question.getQuestionID());
			System.out.println(question.getTitle());
			System.out.println("db1");
			
			
			
			session.delete(ent);

			tx.commit();
			System.out.println("Deleted!");
		} catch (Exception ex) {
			System.out.println("catch!");
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			System.out.println("session closed!");
			session.close();
		}
	}

	public List<Question> FunRetrieve() {
		System.out.println("Funretrieve start");
		session = HibernateUtil.getSession();
		Criteria crit=session.createCriteria(Question.class);
		crit.createCriteria("user","u");
		crit.createCriteria("language","l");
		crit.addOrder(Order.desc("QuestionID"));
		List<Question> list = crit.list();
		session.close();
		return list;
	}

	public List<Question> FunRetrieve(String title) {
		session = HibernateUtil.getSession();
		System.out.println("Search start");
		Criteria crit = session.createCriteria(Question.class,"question");
		crit.createCriteria("user","u");
		crit.createCriteria("language","l");
		crit.addOrder(Order.desc("QuestionID"));
		
		System.out.println("Between start");
		crit.add(Restrictions.like("question.Title","%"+title+"%",MatchMode.ANYWHERE));
		List<Question> list = crit.list();
		System.out.println("After Start");
		System.out.println(list);
		session.close();
		return list;
	}
	
	public List<Question> FunRetrieve(int languageID, String title) {
		session = HibernateUtil.getSession();
		System.out.println("Search start");
		Criteria crit = session.createCriteria(Question.class,"question");
		crit.createCriteria("user","u");
		crit.createCriteria("language","l");
		crit.addOrder(Order.desc("QuestionID"));
		
		System.out.println("Between start");
		if(languageID > 0)			
			crit.add(Restrictions.eq("l.LanguageID", languageID));
		
		crit.add(Restrictions.like("question.Title","%"+title+"%",MatchMode.ANYWHERE));
		List<Question> list = crit.list();
		System.out.println("After Start");
		System.out.println(list);
		session.close();
		return list;
	}
}

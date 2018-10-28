package service;

import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import entity.*;

public class DBAnswer {
	Transaction tx = null;
	Session session = null;

	public List<Answer> FunRetrieve_by_questionlist(int languageid1) {
		session = HibernateUtil.getSession();

		Criteria critqq = session.createCriteria(Question.class, "q");
		// crit.add(Restrictions.eq("description","Mouse")); //for equal//
		critqq.createCriteria("language", "l");
		critqq.createCriteria("user", "u");
		critqq.add(Restrictions.eq("l.LanguageID", languageid1));
		critqq.addOrder(Order.desc("QuestionID"));

		List<Question> qList = critqq.list();

		System.err.println("qList is " + qList);

		
		boolean _any = false;
		_any = qList.iterator().hasNext();
		
		System.err.println("_any value is " + _any);
		
		List<Answer> list = null ; 
		if (_any) {
			Criteria crit = session.createCriteria(Answer.class, "answ");
			crit.createCriteria("user", "u");
			crit.createCriteria("question", "q");
			crit.add(Restrictions.in("answ.question", qList));

			System.out.println("crit" + crit);
			System.out.println("shaw ..before... shaw");

			list = crit.list();
		}		
		
		System.out.println("shaw ..after... shaw");

		System.out.println("list..." + list);
		session.close();
		return list;
	}

	public List<Answer> selectanswer(int questionid1) {
		session = HibernateUtil.getSession();

		System.err.println("question id - shaw : " + questionid1);

		Criteria critQQ = session.createCriteria(Question.class, "qqq");
		critQQ.createCriteria("user", "uuu");
		critQQ.createCriteria("language", "lll");
		critQQ.add(Restrictions.eq("qqq.QuestionID", questionid1));
		

		Question objQuestion = (Question) critQQ.list().get(0);

		System.out.println("question object : shaw : " + objQuestion);

		Criteria crit = session.createCriteria(Answer.class, "ans");
		crit.createCriteria("user", "u");
		crit.createCriteria("question", "q");
		crit.add(Restrictions.eq("ans.question", objQuestion));
		

		System.out.println("crit" + crit);
		System.out.println("shaw ..before... shaw");

		List<Answer> list = crit.list();
		System.out.println("shaw ..after... shaw");

		System.out.println("list..." + list);
		session.close();
		return list;
	}

	public void saveanswer(Answer answer) {

		System.out.println("question id saveanswer table:" + answer.getAnswerID());
		session = HibernateUtil.getSession();
		System.out.println("got session obj........");
		tx = session.beginTransaction();
		session.save(answer);
		tx.commit();
		System.out.println("Saved!");

	}

	public void FunSave(Answer answer) {
		try {
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx = session.beginTransaction();
			System.out.println("33");
			session.save(answer);

			System.out.println("44");
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

	public void FunUpdate(Answer answer) {
		try {
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx = session.beginTransaction();

			Criteria critQQ = session.createCriteria(Question.class, "qqq");
			critQQ.createCriteria("user", "uuu");
			critQQ.createCriteria("language", "lll");			
			List<Question> objQuestion = (List<Question>) critQQ.list();
			
			Criteria crit = session.createCriteria(Answer.class, "ans");
			crit.createCriteria("user", "u");
			crit.createCriteria("question", "q");
			crit.add(Restrictions.in("ans.question", objQuestion));
			List<Answer> list = crit.list();
			
			Answer ent = (Answer) session.get(Answer.class, answer.getAnswerID());
			ent.setCorrect(answer.isCorrect());
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

	public void FunDelete(Answer answer) {
		try {
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx = session.beginTransaction();

			Criteria critQQ = session.createCriteria(Question.class, "qqq");
			critQQ.createCriteria("user", "uuu");
			critQQ.createCriteria("language", "lll");			
			List<Question> objQuestion = (List<Question>) critQQ.list();
			
			Criteria crit = session.createCriteria(Answer.class, "ans");
			crit.createCriteria("user", "u");
			crit.createCriteria("question", "q");
			crit.add(Restrictions.in("ans.question", objQuestion));
			List<Answer> list = crit.list();
		
			Answer ent = (Answer) session.get(Answer.class, answer.getAnswerID());
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

	public List<Answer> FunRetrieveByQuestionID(int questionid) {
		session = HibernateUtil.getSession();

		System.err.println("question id - shaw : " + questionid);

		Criteria critQQ = session.createCriteria(Question.class, "qqq");
		critQQ.createCriteria("user", "uuu");
		critQQ.createCriteria("language", "lll");
		critQQ.add(Restrictions.eq("qqq.QuestionID", questionid));

		Question objQuestion = (Question) critQQ.list().get(0);

		System.out.println("question object : shaw : " + objQuestion);

		Criteria crit = session.createCriteria(Answer.class, "ans");
		crit.createCriteria("user", "u");
		crit.createCriteria("question", "q");
		crit.add(Restrictions.eq("ans.question", objQuestion));
		

		System.out.println("crit" + crit);
		System.out.println("shaw ..before... shaw");

		List<Answer> list = crit.list();
		System.out.println("shaw ..after... shaw");

		System.out.println("list..." + list);
		session.close();
		return list;
	}

	public List<Answer> FunRetrieve(String answerDescription, int questionid) {
		session = HibernateUtil.getSession();

		System.err.println("question id - shaw : " + questionid);
		System.err.println("answer Description  - shaw : " + answerDescription);

		Criteria critQQ = session.createCriteria(Question.class, "qqq");
		critQQ.createCriteria("user", "uuu");
		critQQ.createCriteria("language", "lll");
		critQQ.add(Restrictions.eq("qqq.QuestionID", questionid));

		Question objQuestion = (Question) critQQ.list().get(0);

		System.out.println("question object : shaw : " + objQuestion);

		Criteria crit = session.createCriteria(Answer.class, "ans");
		crit.createCriteria("user", "u");
		crit.createCriteria("question", "q");
		crit.add(Restrictions.eq("ans.question", objQuestion));
		crit.add((Restrictions.like("ans.DetailDescription", "%" + answerDescription + "%")));
		

		System.out.println("crit" + crit);
		System.out.println("shaw ..before... shaw");

		List<Answer> list = crit.list();
		System.out.println("shaw ..after... shaw");

		System.out.println("list..." + list);
		session.close();
		return list;
	}
}

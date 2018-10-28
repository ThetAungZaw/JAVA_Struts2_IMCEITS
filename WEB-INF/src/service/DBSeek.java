package service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import entity.Answer;
import entity.Language;
import entity.PostData;
import entity.PostingComment;
import entity.Question;

public class DBSeek {
	Transaction tx = null;
	Session session = null;
	private Long all_q_count;

	public Language FunRetrieveLanguage(boolean firstRowOnly) {
		session = HibernateUtil.getSession();
		Criteria c = session.createCriteria(Language.class);
		c.setFirstResult(0);
		c.setMaxResults(1);
		List<Language> list = c.list();
		session.close();

		Language ss = new Language();
		ss.setLanguageID(0);
		ss.setLanguageName("");
		try {
			ss = list.get(0);
		} catch (Exception ex) {
		}

		return ss;
	}

	public Language FunRetrieveByLanguageID(int languageID) {
		session = HibernateUtil.getSession();
		Criteria c = session.createCriteria(Language.class);
		c.add(Restrictions.eq("LanguageID", languageID));
		List<Language> list = c.list();
		session.close();

		Language ss = new Language();
		ss.setLanguageID(0);
		ss.setLanguageName("");
		try {
			ss = list.get(0);
		} catch (Exception ex) {
		}

		return ss;
	}

	public List<Language> FunGetLanguageList() {
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(Language.class);
		List<Language> list = crit.list();
		System.out.println("after getting language list..");
		session.close();
		System.out.println("after clasing session  list.." + list.get(0).getLanguageID());
		return list;
	}

	public List<Question> FunGetQuestionList(int languageid1, int load_more_count) {
		System.err.println("load_more_count in DBfun get datalist () >> " + load_more_count);
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(Question.class, "q");
		// crit.add(Restrictions.eq("description","Mouse")); //for equal//
		crit.createCriteria("language", "l");
		crit.createCriteria("user", "u");
		crit.add(Restrictions.eq("l.LanguageID", languageid1));

		crit.addOrder(Order.desc("QuestionID"));
		crit.setMaxResults(5 * load_more_count);
		List<Question> list = crit.list();

		session.close();
		return list;
	}

	public List<Answer> FunRetrieve_by_questionlist(int languageid1) {
		session = HibernateUtil.getSession();

		Criteria critqq = session.createCriteria(Question.class, "q");
		// crit.add(Restrictions.eq("description","Mouse")); //for equal//
		critqq.createCriteria("language", "l");
		critqq.createCriteria("user", "u");
		critqq.add(Restrictions.eq("l.LanguageID", languageid1));

		List<Question> qList = critqq.list();
		boolean _any = false;
		_any = qList.iterator().hasNext();

		System.err.println("_any value is " + _any);

		List<Answer> list = null;
		if (_any) {
			Criteria crit = session.createCriteria(Answer.class, "answ");
			crit.createCriteria("user", "u");
			crit.createCriteria("question", "q");
			crit.add(Restrictions.in("answ.question", qList));

			System.out.println("crit" + crit);
			System.out.println("shaw ..before... shaw");

			list = crit.list();
		}
		session.close();
		return list;
	}

	public void FunSaveQuestionTable(Question question) {
		try {
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

	public void FunSaveAnswer(Answer answer) {
		System.out.println("Answer object >> " + answer);
		System.out.println("Asnwer id saveanswer table:" + answer.getAnswerID());
		session = HibernateUtil.getSession();
		System.out.println("got session obj........");
		tx = session.beginTransaction();
		session.save(answer);
		tx.commit();
		System.out.println("Saved!");

	}

	public List<Answer> FunGetAnswerList(int questionid1) {
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

		List<Answer> list = crit.list();
		session.close();
		return list;
	}

	public Long getAll_q_count() {
		return all_q_count;
	}

	public void setAll_q_count(Long all_q_count) {
		this.all_q_count = all_q_count;
	}

	//////////////////////////// fun for counting all post list///////////
	public Long FunCountAllQList(int lanid) {
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(Question.class);

		crit.setProjection(Projections.rowCount());
		crit.add(Restrictions.eq("language.LanguageID",lanid));
		all_q_count = (Long) crit.uniqueResult();
		session.close();

		return all_q_count;
	}

}

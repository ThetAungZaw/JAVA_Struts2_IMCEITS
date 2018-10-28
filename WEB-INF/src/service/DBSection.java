package service;

import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import entity.*;

public class DBSection {
	Transaction tx = null;
	Session session = null;

	public void FunSave(Section section) {
		try {
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx = session.beginTransaction();

			session.save(section);

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

	public void FunUpdate(Section section) {
		try {
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx = session.beginTransaction();

			Section ent = (Section) session.get(Section.class, section.getSectionID());
			ent.setSectionName(section.getSectionName());
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

	public void FunDelete(Section section) {
		try {
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx = session.beginTransaction();

			Section ent = (Section) session.get(Section.class, section.getSectionID());
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

	public List<Section> FunRetrieve() {
		session = HibernateUtil.getSession();
		List<Section> list = session.createCriteria(Section.class).list();
		session.close();
		return list;
	}

	@SuppressWarnings("null")
	public List<Section> FunRetrieve(int languageID) {
		session = HibernateUtil.getSession();

		System.err.println("\\\\\\\\\\\\\\\\\\\\\\\\*");
		
		Criteria critLect = session.createCriteria(Lecture.class);
		critLect.createCriteria("section","sect1");
		critLect.createCriteria("language","lang1");
		critLect.add(Restrictions.eq("lang1.LanguageID", languageID));
		
		List<Lecture> lectureListByLanguageID = critLect.list();
		
		System.err.println("sectionListByLanguageID " + lectureListByLanguageID);
		List<Integer> idList = new ArrayList<Integer>(lectureListByLanguageID.size());
		for(int i =0; i< lectureListByLanguageID.size(); i++)
		{
			System.err.println("in for loop");
			Integer sectID = (Integer) lectureListByLanguageID.get(i).getSection().getSectionID();
			
			System.err.println("sectID " + sectID);
			idList.add(i,sectID);						
			System.err.println("add 1 ");
		}
		
		System.err.println("idList " + idList);
		
		List<Section> sectionList = null;
		if(idList.size()>0)
		{
			Criteria crit = session.createCriteria(Section.class,"sect2");
			crit.add(Restrictions.in("sect2.SectionID", idList));
			sectionList = crit.list();
		}
		System.err.println("sectionList " + sectionList);
		
		session.close();
		return sectionList;
	}	
	
	public Section FunRetrieveFirstRowOnly() {
		session = HibernateUtil.getSession();
		Criteria c = session.createCriteria(Section.class);		
		List<Section> list = c.list();
		session.close();

		Section ss = null;
		
		if(list.size() > 0)
			ss = list.get(0);
		
		return ss;
	}

	public List<Section> FunRetrieve(String sectionName) {
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(Section.class);
		// crit.add(Restrictions.eq("description","Mouse")); //for equal//
		crit.add(Restrictions.like("SectionName", "%" + sectionName + "%", MatchMode.ANYWHERE));
		List<Section> list = crit.list();
		session.close();
		return list;
	}
}
package service;

import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import entity.*;

public class DBPostingLike {
	Transaction tx = null;
	Session session = null;

	public void FunSave(PostingLike like) {
		try {
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx = session.beginTransaction();

			session.save(like);

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

	public void FunUpdate(PostingLike like) {
		try {
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx = session.beginTransaction();

			PostingLike ent = (PostingLike) session.get(PostingLike.class, like.getLikeID());
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

	public void FunDelete(PostingLike like) {
		try {
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx = session.beginTransaction();

			PostingLike ent = (PostingLike) session.get(PostingLike.class, like.getLikeID());
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

	public Boolean FunDisableLike(int postID, int userID) {
		
		System.out.println("post id " + postID);
		System.out.println("user id " + userID);
		
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(PostingLike.class,"pk1");
		crit.createCriteria("postdata","p1");
		crit.createCriteria("user","u1");
		crit.add(Restrictions.eq("p1.PostID", postID));
		crit.add(Restrictions.eq("u1.UserID", userID));

		List<PostingLike> list = crit.list();

		System.out.println("list " + list);
		System.out.println("list size " + list.size());
		
		session.close();

		if (list.size() > 0)
			return true;

		else
			return false;

	}
}

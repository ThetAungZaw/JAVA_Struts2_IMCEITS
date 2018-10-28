
package service;

import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import entity.*;

public class DBUser {
	Transaction tx = null;
	Session session = null;

	public void FunSave(User user) {
		try {
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx = session.beginTransaction();

			session.save(user);

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

	public void FunUpdate(User user) {
		try {
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx = session.beginTransaction();

			User ent = (User) session.get(User.class, user.getUserID());
			ent.setAddress(user.getAddress());
			ent.setDOB(user.getDOB());
			ent.setEmail(user.getEmail());
			ent.setGender(user.getGender());
			ent.setPassword(user.getPassword());
			ent.setProfilePictureName(user.getProfilePictureName());
			ent.setUserName(user.getUserName());
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

	public void FunDelete(User user) {
		try {
			session = HibernateUtil.getSession();
			System.out.println("got session obj........");
			tx = session.beginTransaction();
			User ent = (User) session.get(User.class, user.getUserID());
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

	public List<User> FunRetrieve() {
		session = HibernateUtil.getSession();
		List<User> list = session.createCriteria(User.class).list();		
		session.close();
		return list;
	}

	public List<User> FunRetrieve(String userName) {
		
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(User.class);
		// crit.add(Restrictions.eq("description","Mouse")); //for equal//
		crit.add(Restrictions.like("UserName", "%" + userName + "%", MatchMode.ANYWHERE));		
		List<User> list = crit.list();
		session.close();
		return list;
	}

	public User FunRetrieve(User user) {
		User _matchUser = new User();
		_matchUser = null;
		
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(User.class);
		List<User> list = crit.list();

		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			User u = (User) itr.next();
			if (u.getUserName().equals(user.getUserName()) && u.getPassword().equals(user.getPassword())) {

				_matchUser =  u;
				break;
			}
		}
		session.close();
		return _matchUser;
	}
	
	public boolean FunRetrieveDuplicatedName(String userName) {
		
		boolean duplicate = false;
		
		
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("UserName", userName));
		List<User> list = crit.list();
		
		try
		{
			list.get(0).getUserID();
			duplicate = true;
		}
		catch(Exception ex)
		{
			duplicate = false;
		}

		session.close();
		return duplicate;
	}
	
	public int FunRetrieveLastPrimaryKeyID()
	{	
		System.out.println("k 1");
		session = HibernateUtil.getSession();
		
		System.out.println("k 2");
		Criteria crit = session.createCriteria(User.class);
		
		System.out.println("k 3");
		crit.setProjection(Projections.max("UserID"));
		
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
	
	public User FunRetrieve(int userID)
	{			
		session = HibernateUtil.getSession();
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("UserID", userID));
		System.out.println("Ok");
		List<User> list= crit.list();
		User user= new User();
		user=list.get(0);
		System.out.println("ID");
		System.out.println("ID Success");
		session.close();
		return user;		
	}
}

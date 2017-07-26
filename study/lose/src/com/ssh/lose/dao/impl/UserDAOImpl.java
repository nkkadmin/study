package com.ssh.lose.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ssh.lose.dao.UserDAO;
import com.ssh.lose.po.User;

@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

	@Override
	public User login(String name, String password) {
		Transaction tx = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM User WHERE name=? AND password=?");
			query.setString(0, name);
			query.setString(1, password);
			User user = (User) query.uniqueResult();
			tx.commit();
			return user;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (tx != null) {
				tx = null;
			}
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

}

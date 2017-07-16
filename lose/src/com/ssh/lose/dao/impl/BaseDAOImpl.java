package com.ssh.lose.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.lose.dao.BaseDAO;
import com.ssh.lose.po.Page;

/**
 * ¹«¹²dao
 * 
 * @author xsx
 *
 */
public class BaseDAOImpl<T> implements BaseDAO<T> {

	@Autowired
	public SessionFactory sessionFactory;

	private Class<T> entityClazz;

	private Class getClazz() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClazz = (Class) params[0];
		return entityClazz;
	}

	/**
	 * ±£´æ
	 * 
	 * @param t
	 */
	public void save(T t) {
		Transaction tx = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(t);
			tx.commit();
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
	}

	@Override
	public T get(int id) {
		Transaction tx = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			T t = (T) session.get(getClazz(), id);
			tx.commit();
			return t;
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

	@Override
	public List<T> load() {
		Transaction tx = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM "+getClazz().getName());
			tx.commit();
			return query.list();
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

	@Override
	public void delete(T t) {
		Transaction tx = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(t);
			tx.commit();
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
	}

	@Override
	public void update(T t) {
		Transaction tx = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(t);
			tx.commit();
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

	}

	@Override
	public List<T> loadPage(Page page) {
		Transaction tx = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM "+getClazz().getName());
			query.setMaxResults(page.getPageSize());
			query.setFirstResult(page.getInPage());
			tx.commit();
			return query.list();
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

	@Override
	public int count() {
		Transaction tx = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Object count = session.createQuery("SELECT COUNT(*) FROM "+getClazz().getName()).uniqueResult();
			tx.commit();
			return Integer.parseInt(count.toString());
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
		return 0;
	}
}

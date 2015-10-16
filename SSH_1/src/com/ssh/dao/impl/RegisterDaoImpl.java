package com.ssh.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.dao.RegisterDao;

public class RegisterDaoImpl  implements RegisterDao{

	private SessionFactory sessionFactory;
	
	@Autowired 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private Session getCurrentSession(){
		return sessionFactory.openSession();
	}

	@Override
	public void saveObject(Object obj) throws HibernateException {
		Session session = getCurrentSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
	}
	
}

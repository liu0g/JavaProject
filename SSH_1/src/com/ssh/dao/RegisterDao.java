package com.ssh.dao;

import org.hibernate.HibernateException;

public interface RegisterDao {
	public void saveObject(Object obj) throws HibernateException;
}

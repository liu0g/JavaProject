package com.ssh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ssh.entity.User;

public class Test {
	public static void main(String[] args) {
		//��ȡhibernate������Ϣ
		Configuration configuration = new Configuration().configure();
		//����congiuration ����sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//����session
		Session session = sessionFactory.openSession();
		//�����������������
		session.beginTransaction();
		
		//����User����
		User user = new User();
		user.setId(1);
		user.setUsername("admin");
		user.setPassword("111");
		//�������
		session.save(user);
		//�ύ����
		session.getTransaction().commit();
		//�ر�session��sessionFactory
		session.close();
		sessionFactory.close();
	}
}

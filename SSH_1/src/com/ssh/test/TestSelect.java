package com.ssh.test;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ssh.entity.User;

public class TestSelect {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//����StringBulider �����Ӳ�ѯ���
		StringBuilder hq = new StringBuilder();
		//��User�������
		//ע��form��� whereǰ����һ���ո�,:name��ʾ����
		hq.append("from ").append(User.class.getName()).append(" where user_username=:name");
		//����session ����query
		Query query = session.createQuery(hq.toString());
		query.setString("name", "admin");
		//���л� query�Ľ��Ϊһ��list����
		List<User> users = query.list();
		
		if(users != null){
			System.out.println("�û�����");
		}
		for (User user : users){
			System.out.println(user.getUsername());
		}
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}

package com.ssh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ssh.entity.User;

public class Test {
	public static void main(String[] args) {
		//获取hibernate配置信息
		Configuration configuration = new Configuration().configure();
		//根据congiuration 建立sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//开启session
		Session session = sessionFactory.openSession();
		//创建并开启事务对象
		session.beginTransaction();
		
		//创建User对象
		User user = new User();
		user.setId(1);
		user.setUsername("admin");
		user.setPassword("111");
		//保存对象
		session.save(user);
		//提交事务
		session.getTransaction().commit();
		//关闭session和sessionFactory
		session.close();
		sessionFactory.close();
	}
}

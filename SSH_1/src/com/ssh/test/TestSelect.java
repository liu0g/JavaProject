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
		
		//利用StringBulider 来连接查询语句
		StringBuilder hq = new StringBuilder();
		//从User里面查找
		//注意form后和 where前各有一个空格,:name表示参数
		hq.append("from ").append(User.class.getName()).append(" where user_username=:name");
		//利用session 建立query
		Query query = session.createQuery(hq.toString());
		query.setString("name", "admin");
		//序列化 query的结果为一个list集合
		List<User> users = query.list();
		
		if(users != null){
			System.out.println("用户存在");
		}
		for (User user : users){
			System.out.println(user.getUsername());
		}
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}

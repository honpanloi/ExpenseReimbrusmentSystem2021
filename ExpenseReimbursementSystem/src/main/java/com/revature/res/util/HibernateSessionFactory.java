package com.revature.res.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private static SessionFactory sessionFactory;
	
	public static Session getSession() {
		
		if(sessionFactory==null) {
			sessionFactory = new Configuration().configure()
					.setProperty("hibernate.connection.url", "jdbc:postgresql://database-revature-1-25-2021.czjbxklktvfn.us-east-2.rds.amazonaws.com:5432/postgres")
					.setProperty("hibernate.connection.username", "postgres")
					.setProperty("hibernate.connection.password", "Xdsala2002")
					.buildSessionFactory();
		}
		return sessionFactory.getCurrentSession();
		
	}
}

package com.revature.res.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private static SessionFactory sessionFactory;
	
	public static Session getSession() {
		
		if(sessionFactory==null) {
			sessionFactory = new Configuration().configure()
					.setProperty("hibernate.connection.url", "DBURL")
					.setProperty("hibernate.connection.username", "DBUSERNAME")
					.setProperty("hibernate.connection.password", "DBPASSWORD")
					.buildSessionFactory();
		}
		return sessionFactory.getCurrentSession();
		
	}
}

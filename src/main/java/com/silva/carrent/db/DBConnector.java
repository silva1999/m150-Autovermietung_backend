package com.silva.carrent.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnector {
	private static SessionFactory factory = null;
	
	public static Session getSession(){
		if(factory == null){
			factory = new Configuration()
					.configure()
					.buildSessionFactory();
		}
		return factory.openSession();
	}

}

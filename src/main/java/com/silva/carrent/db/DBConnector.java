/**
 * @author 	Leandro Silva
 * @date 	21.01.2019
 * @version	1.0
 * 
 * Class to connect with database.
 */
package com.silva.carrent.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnector {
	private static SessionFactory factory = null;
	
	/**
	 * returns session with configuration
	 * @return session
	 */
	public static Session getSession(){
		if(factory == null){
			factory = new Configuration()
					.configure()
					.buildSessionFactory();
		}
		return factory.openSession();
	}

}

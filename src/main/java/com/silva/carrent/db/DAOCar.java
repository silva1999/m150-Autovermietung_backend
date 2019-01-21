/**
 * @author 	Leandro Silva
 * @date 	21.01.2019
 * @version	1.0
 * 
 * Class to make database changes.
 */
package com.silva.carrent.db;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAOCar {

	/**
	 * Get all cars
	 * @return carList
	 */
	public List<CarEntity> getCarList() {
		String hql = "FROM CarEntity";
		Session session = DBConnector.getSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			List<CarEntity> carList = query.list();
			transaction.commit();
			return carList;
		} catch (HibernateException e) {
			if (transaction != null){
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return null;
	}
	
	/**
	 * Get specific car by id
	 * @param id
	 * @return car
	 */
	public CarEntity getCarById(Integer id) {
		String hql = "FROM CarEntity where id = " + id;
		Session session = DBConnector.getSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			List<CarEntity> carList = query.list();
			CarEntity car = carList.get(0);
			transaction.commit();
			return car;
		} catch (Exception e) {
			if (transaction != null){
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return null;
	}

}

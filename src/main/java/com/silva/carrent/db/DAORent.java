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

public class DAORent {
	
	private DAOCar daoCar = new DAOCar();
	private DAOUser daoUser = new DAOUser();

	/**
	 * Save new entry in db
	 * @param startDate
	 * @param endDate
	 * @param userId
	 * @param carId
	 */
	public void rentCar(String startDate, String endDate, String userId, Integer carId) {
		Session session = DBConnector.getSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			RentEntity rent = new RentEntity();
			rent.setCarEntity(daoCar.getCarById(carId));
			rent.setUserEntity(daoUser.getUserByUserId(userId));
			rent.setStartDate(startDate);
			rent.setEndDate(endDate);
			session.save(rent);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null){
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	/**
	 * Get bookings for a car
	 * @param carId
	 * @return bookings
	 */
	public List<RentEntity> getBookingForCar(Integer carId) {
		String hql = "FROM RentEntity r WHERE r.carEntity = " + carId;
		Session session = DBConnector.getSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			List<RentEntity> bookingList = query.list();
			transaction.commit();
			return bookingList;
		} catch (HibernateException e) {
			if (transaction != null){
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return null;
	}
}

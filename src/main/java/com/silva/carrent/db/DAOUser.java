package com.silva.carrent.db;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAOUser {
	
	public UserEntity getUserByUsername(String username) {
		String hql = "FROM UserEntity u WHERE u.username ='" + username +"'";
		Session session = DBConnector.getSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			List<UserEntity> userList = query.list();
			UserEntity user = userList.get(0);
			transaction.commit();
			return user;
		} catch (Exception e) {
			if (transaction != null){
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return null;
	}
	
	public UserEntity getUserByUserId(String userId) {
		String hql = "FROM UserEntity u WHERE u.userId ='" + userId + "'";
		Session session = DBConnector.getSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			UserEntity user = (UserEntity) query.list().get(0);
			transaction.commit();
			return user;
		} catch (Exception e) {
			if (transaction != null){
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return null;
	}
	
	public void update(UserEntity userEntity) {
		String hql = "update UserEntity SET payments = '" + userEntity.getPayments() +
				"' WHERE userId ='" + userEntity.getUserId() + "'";
		Session session = DBConnector.getSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null){
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

}

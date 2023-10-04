package com.core.fullstack.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.core.fullstack.Entity.Employee;

public class JdbcWithHibernate {

	public static void main(String[] args) {
		// Initialize Hibernate configuration
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			// Perform operations on entities
			Employee entity1 = new Employee();
			entity1.setEmpId("Value1");
			session.save(entity1);

			Employee entity2 = session.get(Employee.class, 2L);
			entity2.setEmpName("New Value");

			// Commit the transaction
			transaction.commit();
		} catch (Exception e) {
			// If an error occurs, roll back the transaction
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			// Close the Session and SessionFactory
			session.close();
			sessionFactory.close();
		}
	}
}

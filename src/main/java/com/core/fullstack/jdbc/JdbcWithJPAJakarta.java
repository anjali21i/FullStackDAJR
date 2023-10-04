package com.core.fullstack.jdbc;

import com.core.fullstack.Entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JdbcWithJPAJakarta {

	public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit-name");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            // Begin the transaction
            transaction.begin();

            // Perform operations on entities
            Employee entity1 = new Employee();
            entity1.setEmpName("Value1");
            em.persist(entity1);

            Employee entity2 = em.find(Employee.class, 2L);
            entity2.setEmpId("N88");
            
            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            // If an error occurs, roll back the transaction
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the EntityManager and EntityManagerFactory
            em.close();
            emf.close();
        }
    }
}

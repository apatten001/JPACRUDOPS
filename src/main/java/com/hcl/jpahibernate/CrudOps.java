package com.hcl.jpahibernate;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CrudOps {

	public void insertEntity() {

		try {
			EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Student student = new Student("Arnold", "Patten", "arnold.patten@hcl.com");
			entityManager.persist(student);
			entityManager.getTransaction().commit();
			entityManager.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findEntity() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Student student = entityManager.find(Student.class, 1);
		System.out.println("student id :: " + student.getId());
		System.out.println("student firstname :: " + student.getFirstName());
		System.out.println("student lastname :: " + student.getLastName());
		System.out.println("student email :: " + student.getEmail());
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void updateEntity() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		Student student = entityManager.find(Student.class, 1);
		System.out.println("student id :: " + student.getId());
		System.out.println("student firstname :: " + student.getFirstName());
		System.out.println("student lastname :: " + student.getLastName());
		System.out.println("student email :: " + student.getEmail());

		// The entity object is physically updated in the database when the transaction
		// is committed
		student.setFirstName("AJ");
		student.setLastName("Madden");
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void removeEntity() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		Student student = entityManager.find(Student.class, 1);
		System.out.println("student id :: " + student.getId());
		System.out.println("student firstname :: " + student.getFirstName());
		System.out.println("student lastname :: " + student.getLastName());
		System.out.println("student email :: " + student.getEmail());
		entityManager.remove(student);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}

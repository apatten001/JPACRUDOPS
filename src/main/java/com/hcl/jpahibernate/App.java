package com.hcl.jpahibernate;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		CrudOps crudOperations = new CrudOps();

		// insert a student into the student table of the database
		crudOperations.insertEntity();

		// find a student by id
		crudOperations.findEntity();

		// update a student by id
		crudOperations.updateEntity();

		// remove a student by id
		crudOperations.removeEntity();

	}

}

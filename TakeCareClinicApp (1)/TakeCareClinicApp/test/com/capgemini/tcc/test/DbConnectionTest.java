package com.capgemini.tcc.test;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.tcc.dao.PatientDAO;
import com.capgemini.tcc.dbutil.DbUtil;
import com.capgemini.tcc.exception.PatientException;


public class DbConnectionTest {
	static PatientDAO patientDAO;
	static Connection connection;
	
	@BeforeClass
	public static void initialise() {
		patientDAO = new PatientDAO();
		connection = null;
	}

	@Before
	public void beforeEachTest() {
		System.out.println("----Starting DBConnection Test Case----\n");
	}

	/**
	 * Test case for Establishing Connection
	 * 
	 * @throws PatientException
	 **/
	@Test
	public void test() throws PatientException {
		Connection connection = DbUtil.getConnection();
		Assert.assertNotNull(connection);
		
	}

	@After
	public void afterEachTest() {
		System.out.println("----End of DBConnection Test Case----\n");
	}

	@AfterClass
	public static void destroy() {
		patientDAO = null;
		connection = null;
	}
}

package com.capgemini.tcc.test;

import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.dao.PatientDAO;
import com.capgemini.tcc.exception.PatientException;



public class PatientDAOTest {
	static PatientDAO dao;
	static PatientBean patient;
	
	@BeforeClass
	public static void initialize() {
		System.out.println("Testing DAO");
		dao = new PatientDAO();
		patient = new PatientBean();
	}
	/*******************************************************
	 * Test case for addPatientDetails()
	 *******************************************************/
	@Test
	public void testAddPatientDetails() throws PatientException {

		assertNotNull(dao.addPatientDetails(patient));

	}
	/******************************************************
	 * Test case for getPatientDetails()
	 ******************************************************/
	@Test
	public void testById() throws PatientException {
		assertNotNull(dao.getPatientDetails(1001));
	}
	
	@AfterClass
	public static void destroy() {
		System.out.println("\nTest Ended");
		dao = null;
		patient = null;
	}
}

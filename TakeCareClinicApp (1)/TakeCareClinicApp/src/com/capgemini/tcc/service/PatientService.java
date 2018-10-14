package com.capgemini.tcc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.dao.*;
import com.capgemini.tcc.exception.PatientException;

public class PatientService implements IPatientService {

	IPatientDAO patientDAO = null;
	
	
	//------------------------ 1. TAKECARE CLINIC Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	addPatientDetails
	 - Input Parameters	:	Patient object
	 - Return Type		:	Integer patientId
	 - Throws			:  	PatientException
	 - Author			:	BHARATH KUMAR S
	 - Creation Date	:	29/11/2017
	 - Description		:	adding patient to database calls dao method addPatientDetails(patient)
	 ********************************************************************************************************/
	@Override
	public int addPatientDetails(PatientBean patient) throws PatientException {
		patientDAO = new PatientDAO();
		int patientId = patientDAO.addPatientDetails(patient);
		return patientId;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	getPatientDetails
	 - Input Parameters	:	Integer patientId
	 - Return Type		:	Patient object
	 - Throws			:  	PatientException
	 - Author			:	BHARATH KUMAR S
	 - Creation Date	:	29/11/2017
	 - Description		:	calls dao method getPatientDetails(patientId)
	 ********************************************************************************************************/
	@Override
	public PatientBean getPatientDetails(int patientId) throws PatientException {
		patientDAO = new PatientDAO();
		PatientBean patient = null;
		patient = patientDAO.getPatientDetails(patientId);
		return patient;

	}
	
	/*******************************************************************************************************
	 - Function Name	:	validateDetails
	 - Input Parameters	:	Patient object
	 - Return Type		:	void
	 - Throws			:  	PatientException
	 - Author			:	BHARATH KUMAR S
	 - Creation Date	:	29/11/2017
	 - Description		:	validates the Patient object
	 ********************************************************************************************************/
	public void validateDetails(PatientBean patient) throws PatientException {

		List<String> validationErrors = new ArrayList<String>();
		//Validating Name
		 
		//Validating Age
		if (!isValidAge(patient.getAge())) {
			validationErrors.add("\nAge should not be negative or zero...\n");
		}
		//Validating Phone number
		if (!isValidPhoneNo(patient.getPhoneNo())) {
			validationErrors
					.add("\nPhone Number should contain only Numbers and minimum 8 and maximum 10 digits long...\n");
		}
		//Validating Description
		if (!isValidDescription(patient.getDescription())) {
			validationErrors
					.add("\nDescription must not exceed 80 characters...\n");
		}
		//Printing validation statements
		if (!validationErrors.isEmpty())
			throw new PatientException(validationErrors + "");
	}
	
	
	//Validation methods
	public boolean isValidName(String name) {
		Pattern namePattern = Pattern.compile("^[A-Za-z]{2,}$");
		Matcher nameMatcher = namePattern.matcher(name);
		return nameMatcher.matches();
	}

	public boolean isValidAge(int age) {
		return (age > 0);
	}

	public boolean isValidId(int id) {
		return (id >= 1000);
	}

	public boolean isValidDescription(String description) {
		Pattern namePattern = Pattern.compile("^[A-Za-z0-9. ]{2,80}$");
		Matcher nameMatcher = namePattern.matcher(description);
		return nameMatcher.matches();
	}
	
	public boolean isValidPhoneNo(long phoneNo){
		String data=String.valueOf(phoneNo);
		Pattern namePattern=Pattern.compile("^[0-9]{8,10}$");
		Matcher nameMatcher=namePattern.matcher(data);
		return nameMatcher.matches();
	}
}
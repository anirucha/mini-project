package com.capgemini.tcc.service;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.PatientException;


public interface IPatientService {
	public int addPatientDetails(PatientBean patient) throws PatientException ;
	public PatientBean getPatientDetails(int patientId) throws PatientException;
}

package com.capgemini.tcc.dao;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.PatientException;

public interface IPatientDAO {
public int addPatientDetails(PatientBean patient) throws PatientException;
public PatientBean getPatientDetails(int patientId) throws PatientException;
}

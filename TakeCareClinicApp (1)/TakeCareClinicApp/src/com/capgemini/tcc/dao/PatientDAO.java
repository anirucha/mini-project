package com.capgemini.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.dbutil.DbUtil;
import com.capgemini.tcc.dbutil.IQueryMapper;
import com.capgemini.tcc.exception.PatientException;

public class PatientDAO implements IPatientDAO {

	static Logger logger = Logger.getLogger("logfile");

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public PatientDAO() {
		PropertyConfigurator.configure("resources//log4j.properties");
	}

//------------------------ 1. TAKECARE CLINIC Application --------------------------
/*******************************************************************************************************
	- Function Name		:	addPatientDetails
	- Input Parameters	:	PatientBean object
	- Return Type		:	Integer patientId
	- Throws			:  	PatientException
	- Author			:	BHARATH KUMAR S
	- Creation Date		:	29/11/2017
	- Description		:	adding patient to database
********************************************************************************************************/
	@Override
	public int addPatientDetails(PatientBean patient) throws PatientException {
		connection = DbUtil.getConnection();
		int patientId = 0;
		int status = 0;

		try {

			preparedStatement = connection
					.prepareStatement(IQueryMapper.PATIENT_INSERT_QUERY);
			preparedStatement.setString(1, patient.getPatientName());
			preparedStatement.setInt(2, patient.getAge());
			preparedStatement.setLong(3, patient.getPhoneNo());
			preparedStatement.setString(4, patient.getDescription());

			status = preparedStatement.executeUpdate();

			preparedStatement = connection
					.prepareStatement(IQueryMapper.PATIENT_ID_QUERY_SEQUENCE);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				patientId = resultSet.getInt(1);
			}

			if (status == 0) {
				logger.error("Insertion failed");
				System.err.println("Insertion failed");
				return patientId;
			} else {
				logger.info("Patient Information inserted");
				return patientId;
			}

		} catch (SQLException sqlex) {
			logger.error("Database problem : data not stored");
			throw new PatientException("DB PROBLEM : Data not stored: "
					+ sqlex.getMessage());
		}

		finally {

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					logger.error("Couldn't close the connection");
					throw new PatientException("Problem in closing connection");
				}
			}
		}

	}
		
		
/*******************************************************************************************************
	- Function Name		:	getPatientDetails
	- Input Parameters	:	Integer patientId
	- Return Type		:	PatientBean object
	- Throws			:  	PatientException
	- Author			:	BHARATH KUMAR S
	- Creation Date		:	29/11/2017
	- Description		:	gets patient details from database
********************************************************************************************************/
	@Override
	public PatientBean getPatientDetails(int patientId) throws PatientException {
		
		connection = DbUtil.getConnection();

		try {

			PatientBean patient = null;
			preparedStatement = connection
					.prepareStatement(IQueryMapper.PATIENT_SELECTBYID_QUERY);
			preparedStatement.setInt(1, patientId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				patient = new PatientBean();
				patient.setPatientId(resultSet.getInt(1));
				patient.setPatientName(resultSet.getString(2));
				patient.setAge(resultSet.getInt(3));
				patient.setPhoneNo(resultSet.getLong(4));
				patient.setDescription(resultSet.getString(5));
				patient.setConsultationDate(resultSet.getDate(6));
			}

			if (patient != null) {
				logger.info("Patient Details retrieved using ID");
				return patient;
			} else {
				logger.error("There is no patient in this ID");
				return null;
			}

		} catch (Exception e) {
			logger.error("Couldn't get patient details");
			throw new PatientException("Couldn't get Patient details");
		} finally {

			try {
				connection.close();
			} catch (SQLException e) {
				logger.error("Error in closing connection");
				throw new PatientException(
						"Error closing the connection : " + e.getMessage());

			}
		}
	}
}

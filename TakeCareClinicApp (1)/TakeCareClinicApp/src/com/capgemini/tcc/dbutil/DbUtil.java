package com.capgemini.tcc.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.capgemini.tcc.exception.PatientException;

public class DbUtil {
	private static Connection connection = null;

	/*************************************************************************************
	 *  - @throws PatientException
	 *  - Return type 		: Connection
	 *  - Author 			: BHARATH KUMAR S 
	 *  - Creation Date 	: 29/11/2017
	 *  - Desc				: Gets the Database connection
	 ***************************************************************************************/
	public static Connection getConnection() throws PatientException {
		try {
			connection = DriverManager.getConnection(IQueryMapper.URL,
					IQueryMapper.USERNAME, IQueryMapper.PASSWORD);
			return connection;
		} catch (SQLException e) {
			throw new PatientException("Error connecting db: " + e.getMessage());
		}
	}
}

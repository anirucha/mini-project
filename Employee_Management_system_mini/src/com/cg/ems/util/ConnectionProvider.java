package com.cg.ems.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;





import org.apache.log4j.Logger;

import com.cg.ems.exception.EMSException;


public class ConnectionProvider {

	public static ConnectionProvider defaultInstance = null;

	private static String driver;
	private static String user;
	private static String pwd;
	private static String url;

	static Logger logger = Logger.getLogger("applog");

	private ConnectionProvider() throws EMSException {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("resources/db.properties"));
			user = props.getProperty("db.user");
			driver = props.getProperty("db.driver");
			pwd = props.getProperty("db.password");
			url = props.getProperty("db.url");
			Class.forName(driver);
			logger.info("Driver Loaded");
		} catch (ClassNotFoundException e) {
			logger.error("Driver configuration error");
			throw new EMSException(Messages.DRIVER_CLASS_NOT_FOUND);
		} catch (FileNotFoundException e) {
			logger.error("File not Found Error");
			throw new EMSException(Messages.FILE_NOT_FOUND);
		} catch (IOException e) {
			logger.error("IO Operation Error");
			throw new EMSException(Messages.INPUT_OUTPUT_OPERATION_FAILED);
		}
	}

	public static Connection getConnection() throws EMSException {
		Connection con = null;
		
		if(defaultInstance == null)
			defaultInstance = new ConnectionProvider();

		try {
			if (url != null && user != null && pwd != null) {
				con = DriverManager.getConnection(url, user, pwd);
			} else
				throw new EMSException(Messages.CONNECTION_NOT_CONFIGURED);
		} catch (SQLException e) {
			logger.error("Data Error: Could not be connected");
			throw new EMSException(Messages.CONNECTION_NOT_ESTABLISHED);
		}
		return con;
	}
}

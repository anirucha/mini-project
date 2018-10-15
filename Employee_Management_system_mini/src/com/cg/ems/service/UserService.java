package com.cg.ems.service;

import java.util.List;

import com.cg.ems.bean.Employee;
import com.cg.ems.dao.IUserDao;
import com.cg.ems.dao.UserDaoImpl;
import com.cg.ems.exception.EMSException;

public class UserService implements IUserService {

	IUserDao userDao;
	
	
	public UserService() {
		userDao = new UserDaoImpl();
	}

	//Calls DAO Class method to get employee by id
	@Override
	public Employee getEmployeeById(String empId) throws EMSException {
		return userDao.getEmployeeById(empId);
	}
	
	//Calls DAO Class method to search by id & wild card character
	@Override
	public List<Employee> searchById(String empId, char wildcardChar) throws EMSException {
		return userDao.searchById(empId, wildcardChar);
	}

	//Calls DAO Class method to search by first name & wild card character
	@Override
	public List<Employee> searchByFirstName(String empFName, char wildcardChar) throws EMSException {
		return userDao.searchByFirstName(empFName, wildcardChar);
	}

	//Calls DAO Class method to search by last name & wild card character
	@Override
	public List<Employee> searchByLastName(String empLName, char wildcardChar) throws EMSException {
		return userDao.searchByLastName(empLName, wildcardChar);
	}

	//Calls DAO Class method to search by list of department names
	@Override
	public List<Employee> searchByDept(List<String> empDeptNames) throws EMSException {
		return userDao.searchByDept(empDeptNames);
	}
	
	//Calls DAO Class method to search by list of grades

	@Override
	public List<Employee> searchByGrade(List<String> empGrades) throws EMSException {
		return userDao.searchByGrade(empGrades);
	}

	//Calls DAO Class method to search by list of marital status
	@Override
	public List<Employee> searchByMarital(List<String> empMarital) throws EMSException {
		return userDao.searchByMarital(empMarital);
	}

}

package com.cg.ems.service;


import java.util.List;

import com.cg.ems.bean.EmployeeLeave;
import com.cg.ems.dao.ILeaveApplicationDao;
import com.cg.ems.dao.LeaveApplicationDaoImpl;
import com.cg.ems.exception.EMSException;

public class LeaveApplicationServiceImpl implements ILeaveApplicationService {

	ILeaveApplicationDao leaveApplicationDao;
	
	public LeaveApplicationServiceImpl() {
		leaveApplicationDao = new LeaveApplicationDaoImpl();
	}

	


	//Calls DAO Class method to apply for leave
	@Override
	public boolean applyLeave(EmployeeLeave empLeave) throws EMSException {
		
		return leaveApplicationDao.applyLeave(empLeave);
	}

	//Calls DAO Class method to approve leave by id
	@Override
	public boolean approveLeave(int leaveId) throws EMSException {
		
		return leaveApplicationDao.approveLeave(leaveId);
	}




	////Calls DAO Class method to reject leave by id
	@Override
	public boolean rejectLeave(int leaveId) throws EMSException {
		
		return leaveApplicationDao.rejectLeave(leaveId);
	}



	//Calls DAO Class method to display list of all applied leaves

	@Override
	public List<EmployeeLeave> getAllAppliedLeaves(String mgrId) throws EMSException {
	
		return leaveApplicationDao.getAllAppliedLeaves(mgrId);
	}

}

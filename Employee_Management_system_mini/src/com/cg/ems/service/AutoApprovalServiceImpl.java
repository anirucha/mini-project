package com.cg.ems.service;

import java.util.List;

import com.cg.ems.bean.Employee;
import com.cg.ems.bean.EmployeeLeave;
import com.cg.ems.dao.AutoApprovalDaoImpl;
import com.cg.ems.dao.IAutoApprovalDao;
import com.cg.ems.exception.EMSException;

public class AutoApprovalServiceImpl implements IAutoApprovalService {

	IAutoApprovalDao autoApprovalDao;
	
	public AutoApprovalServiceImpl() {
		autoApprovalDao = new AutoApprovalDaoImpl();
	}
	
	//Calls DAO Class method to list employee leaves
	@Override
	public List<EmployeeLeave> autoApprove() throws EMSException {
		return autoApprovalDao.autoApprove();
	}

}

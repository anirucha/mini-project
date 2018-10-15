package com.cg.ems.service;

import java.util.List;

import com.cg.ems.bean.Employee;
import com.cg.ems.bean.EmployeeLeave;
import com.cg.ems.exception.EMSException;

public interface IAutoApprovalService {

	List<EmployeeLeave> autoApprove() throws EMSException;
}

package com.symphony.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.symphony.dao.EmployeeDao;
import com.symphony.model.Employee;
import com.symphony.service.EmployeeExistsException;
import com.symphony.service.EmployeeManager;

@Service("employeeManager")
@WebService(serviceName = "EmployeeService", endpointInterface = "com.symphony.service.EmployeeService")
public class EmployeeManagerImpl extends GenericManagerImpl<Employee, Long> implements EmployeeManager {
	private EmployeeDao employeeDao;
	
	@Override
	@Autowired
	public void setEmployeeDao(final EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;		
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) throws EmployeeExistsException {
		return employeeDao.save(employee);
	}

	@Override
	public void removeEmployee(Long employeeId) {
		employeeDao.remove(employeeId);
	}
	
	
}

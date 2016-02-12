package com.symphony.dao;

import java.util.Date;
import java.util.List;

import com.symphony.model.Employee;
import com.symphony.model.Salary;

/**
 * User Data Access Object (GenericDao) interface.
 *
 */
public interface EmployeeDao extends GenericDao<Employee, Long> {



    /**
     * Gets a list of users ordered by the uppercase version of their username.
     *
     * @return List populated list of users
     */
	public List<Salary> getSalaryYearOnYear(Long employeeId , Date startDate , Date endDate) ;
	
	
	public List<Salary> getSalaryPaidPerPeriod(Date startDate , Date endDate) ;

    
}

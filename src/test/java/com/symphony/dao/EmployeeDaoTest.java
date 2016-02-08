package com.symphony.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.symphony.model.Salary;

public class EmployeeDaoTest extends BaseDaoTestCase {

    @Autowired
    private EmployeeDao employeeDao;
    
    @Test
	public void testGetSalary() {
    	List<Salary> salaryList = employeeDao.getSalaryYearOnYear(1L,2015);
    	System.out.println(salaryList.size());
    	Assert.assertEquals(1, salaryList.size());
	}

    
}

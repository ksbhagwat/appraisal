package com.symphony.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.symphony.model.Employee;
import com.symphony.model.Salary;

public class EmployeeDaoTest extends BaseDaoTestCase {

    @Autowired
    private EmployeeDao employeeDao;
    
    @Before
    public void setup(){
    	Employee employee1 = new Employee();
    	employee1.setEmail("ksbhagwat@gmail.com");
    	employee1.setFirstName("Kiran");
    	employee1.setLastName("Bhagwat");
    	List<Salary> salaryList =  new ArrayList<Salary>();
    	Salary salary1 = new Salary();
    	salary1.setBasic(BigDecimal.valueOf(10000));
    	salary1.setConveyance(BigDecimal.valueOf(2000));
    	salary1.setHra(BigDecimal.valueOf(8000));
    	salary1.setMedical(BigDecimal.valueOf(1250));
    	salary1.setProvidendFund(BigDecimal.valueOf(6000));
    	Calendar startDt1 = Calendar.getInstance();
    	startDt1.set(2015, 1, 1);
    	Calendar endDt1 = Calendar.getInstance();
    	endDt1.set(2015, 1, 31);
    	
    	salary1.setStartDate(startDt1.getTime());
    	salary1.setEndDate(endDt1.getTime());
    	salaryList.add(salary1);
    	employee1.setSalaryList(salaryList);
    	
    	employeeDao.save(employee1);
    	
    }
    
    @Test
	public void testGetSalary() {
    	List<Salary> salaryList = employeeDao.getSalaryYearOnYear(1L,toStartOfYear(2015),toEndOfYear(2015));
    	Assert.assertEquals(1, salaryList.size());
	}

    public Date toStartOfYear(int year) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.YEAR, year);
	    calendar.set(Calendar.DAY_OF_YEAR, 1);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    return calendar.getTime();
	}

	public Date toEndOfYear(int year) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.YEAR, year);
	    calendar.set(Calendar.MONTH, 11);
	    calendar.set(Calendar.DAY_OF_MONTH, 31);
	    calendar.set(Calendar.HOUR_OF_DAY, 11);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND,59);
	    return calendar.getTime();
	}
	
	
}

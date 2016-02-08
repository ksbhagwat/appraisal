package com.symphony.dao.hibernate;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.symphony.dao.EmployeeDao;
import com.symphony.model.Employee;
import com.symphony.model.Salary;
@Repository("employeeDao")
public class EmployeeDaoHibernate extends GenericDaoHibernate<Employee, Long>  implements EmployeeDao {


	public EmployeeDaoHibernate() {
		super(Employee.class);
	}

	@Override
	public List<Salary> getSalaryYearOnYear(Long employeeId , int year) {
		List<Salary> salaryList = getSession().createCriteria(Salary.class).
	add(Restrictions.eq("employee.id", employeeId)).
	add(Restrictions.le("startDate", toEndOfYear(year))).
	add(Restrictions.ge("endDate", toStartOfYear(year))).
	list();
		return salaryList;
	}

	public Date toStartOfYear(int year) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.YEAR, year);
	    calendar.set(Calendar.DAY_OF_YEAR, 1);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    System.out.println(calendar.getTime());
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
	    System.out.println(calendar.getTime());
	    return calendar.getTime();
	}
	@Override
	public Employee save(Employee employee) {
        if (log.isDebugEnabled()) {
            log.debug("employee" + employee.getId());
        }
        getSession().saveOrUpdate(employee);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return employee;
    }

}

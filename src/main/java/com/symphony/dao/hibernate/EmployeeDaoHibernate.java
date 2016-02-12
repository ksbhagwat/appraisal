package com.symphony.dao.hibernate;

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
	public List<Salary> getSalaryYearOnYear(Long employeeId , Date startDate , Date endDate) {
		List<Salary> salaryList = getSession().createCriteria(Salary.class).
	add(Restrictions.eq("employee.id", employeeId)).
	add(Restrictions.le("startDate", endDate)).
	add(Restrictions.ge("endDate", startDate)).
	list();
		return salaryList;
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

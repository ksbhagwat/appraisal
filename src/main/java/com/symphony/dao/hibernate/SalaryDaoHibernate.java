package com.symphony.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.symphony.dao.SalaryDao;
import com.symphony.model.Salary;
@Repository("salaryDao")
public class SalaryDaoHibernate extends GenericDaoHibernate<Salary, Long>  implements SalaryDao  {
	
	public SalaryDaoHibernate() {
		super(Salary.class);
	}
	
	@Override
	public Salary save(Salary salary) {
        if (log.isDebugEnabled()) {
            log.debug("salary" + salary.getId());
        }
        getSession().saveOrUpdate(salary);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return salary;
    }
}

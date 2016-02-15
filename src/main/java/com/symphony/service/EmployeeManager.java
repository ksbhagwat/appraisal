package com.symphony.service;

import java.util.List;

import org.appfuse.service.UserExistsException;

import com.symphony.dao.EmployeeDao;
import com.symphony.model.Employee;


/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 */
public interface EmployeeManager extends GenericManager<Employee, Long> {
    /**
     * Convenience method for testing - allows you to mock the DAO and set it on an interface.
     * @param userDao the UserDao implementation to use
     */
    void setEmployeeDao(EmployeeDao employeeDao);

   
    /**
     * Retrieves a list of all users.
     * @return List
     */
    List<Employee> getEmployees();

    /**
     * Saves a user's information.
     *
     * @param user the user's information
     * @throws UserExistsException thrown when user already exists
     * @return user the updated user object
     */
    Employee saveEmployee(Employee employee) throws EmployeeExistsException;
    
    void removeEmployee(Long employeeId);
    
    

   
}

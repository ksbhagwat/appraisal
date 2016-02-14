package com.symphony.webapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.symphony.model.Employee;
import com.symphony.service.EmployeeExistsException;
import com.symphony.service.EmployeeManager;

@Controller
@RequestMapping("/employeeform*")
public class EmployeeFormController extends BaseFormController {
    private final Log log = LogFactory.getLog(EmployeeFormController.class);

    @Autowired
    EmployeeManager employeeManager;

    @Autowired(required = false)
    Validator validator;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Employee employee, BindingResult result, HttpServletRequest request) throws Exception {

        if (request.getParameter("cancel") != null) {
            return "redirect:employees";
        }

       /* if (validator != null && request.getParameter("delete") == null) { // validator is null during testing
            validator.validate(user, result);

            if (result.hasErrors()) {
                return "userform";
            }
        }*/

        log.debug("entering 'onSubmit' method...");

        if (request.getParameter("delete") != null) {
            employeeManager.removeEmployee(employee.getId());
            saveMessage(request, getText("employee.deleted", employee.getFirstName(), request.getLocale()));
        } else {
            try {
            	employeeManager.saveEmployee(employee);
            } catch (EmployeeExistsException uex) {
                result.addError(new ObjectError("employee", uex.getMessage()));
                return "employeeform";
            }
            saveMessage(request, getText("employee.saved", employee.getFirstName(), request.getLocale()));
        }

        return "redirect:employees";
    }

    @RequestMapping("/employees*")
    protected Map getEmployeeList(HttpServletRequest request) {
    	Map employeeMap = new HashMap();
    	List<Employee> employeeList = employeeManager.getEmployees();
    	for(Employee employee : employeeList){
        	employeeMap.put(employee.getFirstName(), employee.getId());
    	}
            
            return employeeMap;
    }
}

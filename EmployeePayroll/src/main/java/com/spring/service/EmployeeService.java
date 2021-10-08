package com.spring.service;

import com.spring.entities.Employee;
import com.spring.respository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/** service layer of the project where all business logic is stored */

@Component
public class EmployeeService {
    final
    EmployeeRepo employeeRepo;

    /** autowired the repository class using constructor */
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    /** method to save employee with the help of employee repository */


    /**
     *
     * @param employee
     * @return
     */
    public Employee saveEmployee(Employee employee){
        Employee savedEmployee = employeeRepo.save(employee);
        System.out.println("Employee saved successfully");
        return savedEmployee;
    }
    /** method to delete employee with the help of employee repository */
    public void deleteEmployee(int id){
        employeeRepo.deleteById(id);
        System.out.println("Employee deleted successfully");
    }

    /** method to find employee by id with the help of employee repository */
    public Employee findById(int id){
         return  employeeRepo.findById(id);
    }

    /** method to find all employees with the help of employee repository */
    public List<Employee> findAll(){
        return (List<Employee>) employeeRepo.findAll();
    }


    /** method to update existing employee with the help of employee repository */
    public Employee updateEmployee(Employee employee , int id){
        employee.setId(id);
        return employeeRepo.save(employee);
    }


    /** method to count number of employees with the help of employee repository */
    public Long countEmployee(){
        return employeeRepo.count();
    }
}

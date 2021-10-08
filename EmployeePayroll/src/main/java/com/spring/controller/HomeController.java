package com.spring.controller;

import com.spring.entities.Employee;
import com.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** the programme starts from /employee mapping*/

@RestController
@RequestMapping("/employee")
public class HomeController  {
    final
    EmployeeService employeeService;

    /** the service class has been autowired for dependency injection on run time*/

    @Autowired
    public HomeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /** the database used is mysql*/
    /** this is the mapping to get all employees from database*/

    /**
     *
     * @return
     */
    @GetMapping("/findAllEmployee")
    public List<Employee> getAllEmployee(){
        return employeeService.findAll();
     }

    /** this is the mapping to get single employee by id from database*/
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public Employee findById( @PathVariable("id") int id){
        return employeeService.findById(id);
    }

    /** this is the mapping to add single employee in database*/
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    /** this is the mapping to delete single employee by id from database*/
    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
    }

    /** this is the mapping to update single employee by id from database*/
    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee , @PathVariable("id") int id){
        return employeeService.updateEmployee(employee ,id );
    }

    /** this is the mapping to get count employees  from database*/
    @GetMapping("/getNumberOfEmployees")
    public Long countEmployee(){
        return employeeService.countEmployee();
    }

}

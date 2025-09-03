package dev.vamsi.springsecurity.Controllers;

import dev.vamsi.springsecurity.Models.Employee;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    Employee emp1 = new Employee(1,"Raj",100000);
    Employee emp2 = new Employee(2,"Jan",20000);
    List<Employee> employees = new ArrayList<Employee>();
    @GetMapping("/students")
    public List<Employee> getEmployees() {
        employees.add(emp1);
        employees.add(emp2);
        LOGGER.info("Returning Employees list");
        return employees;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Employee addEmployee(@RequestBody Employee emp) {
        employees.add(emp);
        LOGGER.info("Given employee added");
        return emp;
    }
}

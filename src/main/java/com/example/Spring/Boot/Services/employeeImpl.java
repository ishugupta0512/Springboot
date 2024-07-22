package com.example.Spring.Boot.Services;

import com.example.Spring.Boot.Entities.Employee;
import com.example.Spring.Boot.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class employeeImpl {

    @Autowired
    EmployeeRepository er;

    public Employee createNewEmployee(Employee employee){
        Employee em = er.save(employee);
        return em;
    }

    public Iterable<Employee> createNewEmployees(ArrayList<Employee> employeesArray){
        Iterable<Employee> em = er.saveAll(employeesArray);
        return em;
    }

    public Iterable<Employee> getExistingEmployees(){
        Iterable<Employee> allEmps =  er.findAll();
        return allEmps;
    }

    public Optional<Employee> findEmployeebyID(Integer employeeID){
        Optional<Employee> employee = er.findById(employeeID);
        return employee;

    }


    public Employee updateEmployeeRecord(Integer employeeId, String company){
        Optional<Employee> em = er.findById(employeeId);
        Employee employeeLocalVariable;
        if(em.isPresent()){
            Employee tobe = em.get();
            tobe.setCompany_name(company);
            employeeLocalVariable = er.save(tobe);
        }
        else {
            throw new RuntimeException("Employee not found with ID: "+ employeeId);
        }
        return employeeLocalVariable;
    }


}

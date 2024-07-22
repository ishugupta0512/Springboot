package com.example.Spring.Boot.Controllers;

import com.example.Spring.Boot.Entities.Employee;
import com.example.Spring.Boot.Services.employeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    employeeImpl employeeIMPL;



    // Creates a single Record
    @PostMapping("/createEmployee")
    public ResponseEntity<Employee> createNewEmployee(@RequestBody Employee newEmployee){
      Employee createdEmployee = employeeIMPL.createNewEmployee(newEmployee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.OK);
    }

    // Creates Multiple Records
    @PostMapping("/createEmployees")
    public ResponseEntity<Iterable<Employee>> createNewEmployee(@RequestBody ArrayList<Employee> newEmployees){
        Iterable <Employee> createdEmployee = employeeIMPL.createNewEmployees(newEmployees);
        return new ResponseEntity<>(createdEmployee, HttpStatus.OK);
    }

    // Returns All Records
    @GetMapping("/getEmployees")
    public ResponseEntity<Iterable<Employee>> getEmployees(){
        Iterable<Employee> empResponse = employeeIMPL.getExistingEmployees();
        return new ResponseEntity<>(empResponse, HttpStatus.OK);
    }

    // Returns Record based on ID
    @GetMapping("/getEmployees/{employeeId}")
    public ResponseEntity<Optional<Employee>> getEmployees(@PathVariable Integer employeeId){
        Optional<Employee> empResponse = employeeIMPL.findEmployeebyID(employeeId);
        return new ResponseEntity<>(empResponse, HttpStatus.OK);
    }

    // Update a record
    @PutMapping("/updateEmployee/{employeeId}/{newCompany}")
    public ResponseEntity<Employee> getEmployees(@PathVariable Integer employeeId, @PathVariable String newCompany){
        Employee empResponse = employeeIMPL.updateEmployeeRecord(employeeId, newCompany);
        return new ResponseEntity<>(empResponse, HttpStatus.OK);
    }


}

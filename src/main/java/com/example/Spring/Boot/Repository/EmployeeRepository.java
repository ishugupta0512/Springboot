package com.example.Spring.Boot.Repository;
import com.example.Spring.Boot.Entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {


}

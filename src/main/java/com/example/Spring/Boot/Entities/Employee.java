package com.example.Spring.Boot.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Employee {

    @Id
    private int employee_id;
    private String employee_name;
    private String company_name;

}

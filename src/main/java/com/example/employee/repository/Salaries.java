package com.example.employee.repository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Salaries {
    @Id
    private int empNo;
    private int salary;
    private String fromDate;
    private String toDate;
}

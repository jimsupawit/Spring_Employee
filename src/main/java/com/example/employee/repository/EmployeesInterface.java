package com.example.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesInterface extends CrudRepository<Employees, String>{
    public Employees findByEmpNo(int empNo);
}

package com.example.employee.controller;

import com.example.employee.repository.Employees;
import com.example.employee.repository.EmployeesInterface;
import com.example.employee.repository.Salaries;
import com.example.employee.repository.SalaryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
public class EmployeesController {
    @Autowired
    private EmployeesInterface employees;
    @Autowired
    private SalaryInterface salaries;


    @RequestMapping(value = "/employee/createEmployee", method = RequestMethod.POST)
    public @ResponseBody boolean addAccount(@RequestBody Map<String, String> json){
        int empNo = Integer.parseInt(json.get("emp_no"));
        String birthDate = json.get("birth_date");
        String fistName = json.get("first_name");
        String lastName = json.get("last_name");
        String gender = json.get("gender");
        String hireDate = json.get("hire_date");
        int sal = Integer.parseInt(json.get("salary"));
        String fromDate = json.get("from_date");
        String toDate = json.get("to_date");
        Employees employ = new Employees(empNo, birthDate, fistName, lastName, gender, hireDate);
        Salaries amount = new Salaries(empNo, sal, fromDate, toDate);
        employees.save(employ);
        salaries.save(amount);
        return true;
    }


    @RequestMapping(value = "/employee/searchEmployee", method = RequestMethod.GET)
    public @ResponseBody
    Employees findByEmpNo(@RequestParam("empNo") int empNo){
        return employees.findByEmpNo(empNo);
    }
}

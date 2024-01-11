package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.entity.Employee;

@Service
public interface EmployeeService {

	Employee addEmployee(Employee employee);

	Employee getEmployeeByEmpId(Integer empId);

	Employee getEmployeeByName(String name);

	Employee updateEmployee(Integer empId);

	void deleteEmployee(Integer empId);

	List<Employee> getAllEmployee();

	List<Employee> getAllEmployeeByName(String name);

}

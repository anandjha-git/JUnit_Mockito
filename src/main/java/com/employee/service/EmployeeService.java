package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employee.entity.Employee;

@Service
public interface EmployeeService {

	Employee addEmployee(Employee employee);

	Employee getEmployeeByEmpId(Integer empId);

	Employee getEmployeeByName(String name);

	Boolean deleteEmployee(Integer empId);

	List<Employee> getAllEmployee();

	List<Employee> getAllEmployeeByName(String name);

	Employee updateEmployee(Integer empId, Employee employee);

}

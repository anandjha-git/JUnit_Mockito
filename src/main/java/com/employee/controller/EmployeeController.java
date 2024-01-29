package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addEmployee")
	ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/getEmployee/{empId}")
	ResponseEntity<Employee> getEmployeeByEmpId(@PathVariable("empId") Integer empId) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeByEmpId(empId), HttpStatus.FOUND);
	}

	@GetMapping("/getEmployeeByName/{Name}")
	ResponseEntity<Employee> getEmployeeByEmployeeName(@PathVariable("Name") String employeeName) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeByName(employeeName), HttpStatus.FOUND);
	}

	@DeleteMapping("/deleteEmployee/{Id}")
	ResponseEntity<Boolean> deleteEmployeeByEmpId(@PathVariable("Id") Integer empId) {
		return new ResponseEntity<Boolean>(employeeService.deleteEmployee(empId), HttpStatus.OK);
	}

	@GetMapping("/getEmployees")
	ResponseEntity<List<Employee>> getAllEmployee() {
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(), HttpStatus.FOUND);
	}

	@GetMapping("/getEmployees/{Name}")
	ResponseEntity<List<Employee>> getAllEmployeeByName(@PathVariable("Name") String employeeName) {
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployeeByName(employeeName), HttpStatus.FOUND);
	}

	@PutMapping("/updateEmployee/{Id}")
	ResponseEntity<Employee> updateEmployeeByEmpId(@PathVariable("Id") Integer empId, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(empId, employee), HttpStatus.OK);
	}

}

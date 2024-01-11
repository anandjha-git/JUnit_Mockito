package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee addEmployee(Employee employee) {

		return repository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeByEmpId(Integer empId) {
		return repository.findById(empId);
	}

	@Override
	public Employee getEmployeeByName(String name) {

		return repository.getByName(name);
	}

	@Override
	public Employee updateEmployee(Integer empId, Employee employee) {
		if (repository.findById(empId) != null) {
			return repository.save(employee);
		}
		return null;
	}

	@Override
	public void deleteEmployee(Integer empId) {
		if (repository.findById(empId) != null) {
			repository.deleteById(empId);
		}

	}

	@Override
	public List<Employee> getAllEmployee() {

		return repository.findAll();
	}

	@Override
	public List<Employee> getAllEmployeeByName(String name) {

		return repository.getAllByName(name);
	}

}

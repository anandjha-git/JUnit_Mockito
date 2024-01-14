package com.employee.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee addEmployee(Employee employee) {

		return repository.save(employee);
	}

	@Override
	public Employee getEmployeeByEmpId(Integer empId) {
		try {
			return repository.getReferenceById(empId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EntityNotFoundException();
		}
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
	public Boolean deleteEmployee(Integer empId) {
		if (repository.findById(empId) != null) {
			repository.deleteById(empId);
			return true;
		}else {
			System.out.println("Employee Not Found");
		}
		return false;
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

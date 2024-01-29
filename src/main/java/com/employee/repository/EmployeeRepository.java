package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value="select e from employee where e.name=?1")
	Employee getByName(String name);
	@Query(value="select * from employee where name=?1")
	List<Employee> getAllByName(String name);
}

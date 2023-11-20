package com.project.modals;

import java.util.List;

import com.project.dao.Employee;

public interface EmployeeBO {
	int save(Employee e);
	int update(Employee e);
	int delete(int id);
	int delete(Employee e);
	Employee get(int id);
	List<Employee> getAll();
}

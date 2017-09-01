package com.formation.daos;

import java.util.List;

import com.formation.entity.EmployeeEntity;

public interface EmployeeDAO {
	
	public void addEmployee(EmployeeEntity employee);
	
	public List<EmployeeEntity> getAllEmployees();
	
	public void deleteEmployee(Integer employeeId);

}

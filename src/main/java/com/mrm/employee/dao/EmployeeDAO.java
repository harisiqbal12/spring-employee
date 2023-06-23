package com.mrm.employee.dao;

import java.util.List;

import com.mrm.employee.entity.Employee;

public interface EmployeeDAO {
  
  List<Employee> findAll();

  Employee findById(int dd);

  Employee save(Employee employee);

  void deleteById(int id);
}

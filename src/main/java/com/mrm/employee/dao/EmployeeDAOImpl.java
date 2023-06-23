package com.mrm.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrm.employee.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

  private EntityManager entityManager;

  @Autowired
  public EmployeeDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAll() {

    TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
    List<Employee> employees = query.getResultList();

    return employees;
  }

  @Override
  public Employee findById(int id) {
    return entityManager.find(Employee.class, id);
  }

  @Override
  public Employee save(Employee employee) {
    return entityManager.merge(employee);
  }

  @Override
  public void deleteById(int id) {
    Employee employee = entityManager.find(Employee.class, id);
    entityManager.remove(employee);
  }

}

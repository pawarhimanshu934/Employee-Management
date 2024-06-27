package com.EmployeeManagment.EmployeeManagement;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface EmpService {
    List<Employee> readAllEmployee();
    String addEmployee(Employee employee);
    String deleteEmployee(Long id);
    String updateEmployee(Long id, Employee employee);
}

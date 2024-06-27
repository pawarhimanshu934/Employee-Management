package com.EmployeeManagment.EmployeeManagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImplement implements EmpService{

    //Using Repository interface methods here in service class.
    @Autowired
    private EmployeeRepository employeeRepository;
    

    @Override
    public List<Employee> readAllEmployee() {

        List<Employee> emp = new ArrayList<>();
        List<EmployeeEntity> employeeList = employeeRepository.findAll();

        for (EmployeeEntity employeeEntity : employeeList) {
            
            Employee employee = new Employee();

            employee.setId(employeeEntity.getId());
            employee.setName(employeeEntity.getName());
            employee.setMobile(employeeEntity.getMobile());
            employee.setEmail(employeeEntity.getEmail());

            emp.add(employee);
        }
        return emp;
    }

    @Override
    public String addEmployee(Employee employee) {
        // emp.add(employee);
        EmployeeEntity employeeEntity = new EmployeeEntity();
        //since we want to copy all things from employee to EmployeeEntity, directly it is not possible.
        // we're using BeanUtils to copy properties from one class to another class.
        BeanUtils.copyProperties(employee, employeeEntity);
        System.out.println(employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Employee Added Successfully";
    }

    @Override
    public String deleteEmployee(Long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return "Employee Deleted successfully";
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).get();

        existingEmployee.setId(employee.getId());
        existingEmployee.setName(employee.getName());
        existingEmployee.setMobile(employee.getMobile());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);
        return "Record updated successfully";

    }

}

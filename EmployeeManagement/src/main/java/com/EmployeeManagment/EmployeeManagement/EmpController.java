package com.EmployeeManagment.EmployeeManagement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    
    @Autowired
    EmpService emp;

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return emp.readAllEmployee();
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee){
        
         return emp.addEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return emp.deleteEmployee(id);
    }

    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return emp.updateEmployee(id, employee);
    }
}

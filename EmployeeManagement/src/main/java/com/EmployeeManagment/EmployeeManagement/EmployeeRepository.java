//Repository class is where we'll perform all the crud operations on emp_db table in database.

package com.EmployeeManagment.EmployeeManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    
}

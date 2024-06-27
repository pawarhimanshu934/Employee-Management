//Entity class will used to map it to the table we've created in DB ( emp_db ). This class will commuincate with table
//Repository class is where we'll perform all the crud operations.

package com.EmployeeManagment.EmployeeManagement;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data //getter and setter
@Entity    //declaring this class as Entity class
@Table(name = "emp_db")  //defining the name of table to which Entity class will be mapped.If you don't define table name it will take name from class name.
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //autogenerate id as primary key
    private Long id;

    private String name;
    private String mobile;
    private String email;
}

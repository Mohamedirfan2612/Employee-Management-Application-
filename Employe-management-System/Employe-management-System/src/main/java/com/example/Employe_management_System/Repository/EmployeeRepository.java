package com.example.Employe_management_System.Repository;

import com.example.Employe_management_System.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}

package com.example.Employe_management_System;

import com.example.Employe_management_System.Entity.Employee;
import com.example.Employe_management_System.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeManagementSystemApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

//		Employee employee1=new Employee("mohamed","irfan","irfan@gmail.com");
//		employeeRepository.save(employee1);
//		Employee employee2=new Employee("mohamed","ibrahim","ibrahim@gmail.com");
//		employeeRepository.save(employee2);
//		Employee employee3=new Employee("mohamed","ashick","ashick@gmail.com");
//		employeeRepository.save(employee3);

	}
}

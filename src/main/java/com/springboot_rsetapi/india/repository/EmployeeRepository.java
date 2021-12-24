package com.springboot_rsetapi.india.repository;

import com.springboot_rsetapi.india.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

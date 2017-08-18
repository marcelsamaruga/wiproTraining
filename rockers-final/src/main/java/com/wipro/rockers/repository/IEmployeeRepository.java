package com.wipro.rockers.repository;


import com.wipro.rockers.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}

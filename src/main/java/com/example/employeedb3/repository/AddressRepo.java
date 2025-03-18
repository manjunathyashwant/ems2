package com.example.employeedb3.repository;

import com.example.employeedb3.entity.Address;
import com.example.employeedb3.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AddressRepo extends JpaRepository<Address,Integer> {

  List<Address> findByEmployee(Employee employee);
}

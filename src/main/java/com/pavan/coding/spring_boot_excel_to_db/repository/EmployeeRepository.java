package com.pavan.coding.spring_boot_excel_to_db.repository;

import com.pavan.coding.spring_boot_excel_to_db.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

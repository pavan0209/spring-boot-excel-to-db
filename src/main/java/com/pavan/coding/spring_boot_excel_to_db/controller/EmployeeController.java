package com.pavan.coding.spring_boot_excel_to_db.controller;

import com.pavan.coding.spring_boot_excel_to_db.model.Employee;
import com.pavan.coding.spring_boot_excel_to_db.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping(value = "/upload-data", consumes = "multipart/form-data")
    public ResponseEntity<String> saveFileData(@RequestParam("file") MultipartFile file) throws IOException {
        employeeService.saveFileData(file.getInputStream());
        return ResponseEntity.ok("Excel file data saved into Database");
    }

    @GetMapping("/read-data")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @DeleteMapping("/delete-data")
    public ResponseEntity<String> deleteAll() {
        employeeService.deleteAll();
        return ResponseEntity.ok("Deleted all records...!");
    }
}

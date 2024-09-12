//In this file we are developing the APIs
package full.stack.employee_management_backend.controller;

import full.stack.employee_management_backend.dto.EmployeeDto;
import full.stack.employee_management_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeservice;

    //Add Employee API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
       EmployeeDto savedEmployee = employeeservice.createEmployee(employeeDto);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") long employeeId)
    {
        EmployeeDto employeeDto = employeeservice.getEmployee(employeeId);
        return ResponseEntity.ok(employeeDto) ;
    }

    // Get All
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees()
    {
        List<EmployeeDto> employees = employeeservice.allEmployee();
        return ResponseEntity.ok(employees);
    }

    // Update Employee
   @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") long employeeId, @RequestBody EmployeeDto updatedEmployee)
    {
        EmployeeDto employeeDto = employeeservice.updateEmployee(employeeId, updatedEmployee );
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId )
    {
        employeeservice.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted");
    }

}

package full.stack.employee_management_backend.service;

import full.stack.employee_management_backend.dto.EmployeeDto;
import full.stack.employee_management_backend.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployee(long employeeId);

    List<EmployeeDto> allEmployee();

    EmployeeDto updateEmployee(long employeeId, EmployeeDto updatedEmployee);

    void deleteEmployee (long employeeId );

}

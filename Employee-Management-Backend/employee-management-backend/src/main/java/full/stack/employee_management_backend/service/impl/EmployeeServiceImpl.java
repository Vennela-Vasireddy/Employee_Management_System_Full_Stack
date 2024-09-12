package full.stack.employee_management_backend.service.impl;

import full.stack.employee_management_backend.dto.EmployeeDto;
import full.stack.employee_management_backend.entity.Employee;
import full.stack.employee_management_backend.exception.ResourceNotFoundException;
import full.stack.employee_management_backend.mapper.EmployeeMapper;
import full.stack.employee_management_backend.repository.EmployeeRepository;
import full.stack.employee_management_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // So first we have convert employeeDto to employee JPA entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        //So now save the converted employee JPA entity to database
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployee(long employeeId) {

        //We are trying to find the employee using id and if there is no id then we are throwing an exception
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("No employee exists with the given id : " + employeeId));

        //And then we are converting
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> allEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("No employee with this" + employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updateEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updateEmployee);
    }

    @Override
    public void deleteEmployee(long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("No employee with this" + employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}

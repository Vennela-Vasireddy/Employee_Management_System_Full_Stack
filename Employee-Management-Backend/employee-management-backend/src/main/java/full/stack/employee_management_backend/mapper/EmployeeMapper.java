package full.stack.employee_management_backend.mapper;

import full.stack.employee_management_backend.dto.EmployeeDto;
import full.stack.employee_management_backend.entity.Employee;

// We use this class to map the Employee entity to EmployeeDto and vice versa

public class EmployeeMapper {

    /*
    * Using this function we are mapping employee entity to EmployeeDto */
    public static EmployeeDto mapToEmployeeDto(Employee employee){

        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()

        ) ;
    }

    /*
     * Using this function we are mapping EmployeeDto to employee entity */
    public static Employee mapToEmployee(EmployeeDto employeeDto)
    {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }

}

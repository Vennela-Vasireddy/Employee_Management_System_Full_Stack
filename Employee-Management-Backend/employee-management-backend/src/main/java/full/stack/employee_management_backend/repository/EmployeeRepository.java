package full.stack.employee_management_backend.repository;

import full.stack.employee_management_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

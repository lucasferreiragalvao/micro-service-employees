package edu.unifacef.employee.gateways.outputs;

import edu.unifacef.employee.domains.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeDataGateway {
    Employee save(Employee employee);

    Optional<Employee> findById(String id);

    Page<Employee> findByPage(Pageable pageable);

    void deleteEmployee(String id);
}

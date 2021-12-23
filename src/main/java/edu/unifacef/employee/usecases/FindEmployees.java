package edu.unifacef.employee.usecases;

import edu.unifacef.employee.domains.Employee;
import edu.unifacef.employee.gateways.outputs.EmployeeDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindEmployees {

    private final EmployeeDataGateway employeeDataGateway;

    public Page<Employee> execute(final Pageable pageable) {
        log.info("Find employees. Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return employeeDataGateway.findByPage(pageable);
    }

}

package edu.unifacef.employee.usecases;

import edu.unifacef.employee.gateways.outputs.EmployeeDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteEmployee {

    private final EmployeeDataGateway employeeDataGateway;

    public void execute(final String id) {
        log.info("Deleting employee. Employee id: {}", id);
        employeeDataGateway.deleteEmployee(id);
    }
}

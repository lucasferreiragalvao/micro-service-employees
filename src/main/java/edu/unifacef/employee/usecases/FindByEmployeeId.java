package edu.unifacef.employee.usecases;

import edu.unifacef.employee.domains.Employee;
import edu.unifacef.employee.exceptions.MessageKey;
import edu.unifacef.employee.exceptions.NotFoundException;
import edu.unifacef.employee.gateways.outputs.EmployeeDataGateway;
import edu.unifacef.employee.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByEmployeeId {
    private final EmployeeDataGateway employeeDataGateway;
    private final MessageUtils messageUtils;

    public Employee execute(String id) {
        log.info("Find employee. Employee code {}", id);
        return employeeDataGateway
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException(messageUtils.getMessage(MessageKey.EMPLOYEE_NOT_FOUND, id))
                );
    }

}

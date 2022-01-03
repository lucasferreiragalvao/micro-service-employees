package edu.unifacef.employee.usecases;

import edu.unifacef.employee.domains.Employee;
import edu.unifacef.employee.exceptions.MessageKey;
import edu.unifacef.employee.gateways.outputs.EmployeeDataGateway;
import edu.unifacef.employee.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateEmployee {

    private final EmployeeDataGateway employeeDataGateway;
    private final MessageUtils messageUtils;

    public Employee execute(final Employee employee) {
        log.info("Create employee. Employee CPF {}", employee.getCpf());

        if(employeeDataGateway.findById(employee.getCpf()).isPresent()) {
            throw new IllegalArgumentException(messageUtils.getMessage(MessageKey.EMPLOYEE_ALREADY_EXISTS, employee.getCpf()));
        }

        Employee saved = employeeDataGateway.save(employee);

        return saved;
    }
}

package edu.unifacef.employee.usecases;

import edu.unifacef.employee.domains.Employee;
import edu.unifacef.employee.domains.Status;
import edu.unifacef.employee.exceptions.MessageKey;
import edu.unifacef.employee.gateways.outputs.EmployeeDataGateway;
import edu.unifacef.employee.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateEmployee {

    private final EmployeeDataGateway employeeDataGateway;
    private final MessageUtils messageUtils;

    public Employee execute(final Employee employee) {
        log.info("Updating employee. Employee id: {}", employee.getId());

        Employee oldEmployee = employeeDataGateway.findById(employee.getId())
                .orElseThrow(() -> new IllegalArgumentException(messageUtils
                        .getMessage(MessageKey.EMPLOYEE_NOT_FOUND, employee.getId())));

        if(!oldEmployee.getCpf().equals(employee.getCpf())) {
            throw new IllegalArgumentException(messageUtils
                    .getMessage(MessageKey.DIFFERENT_EMPLOYEE_CPF, oldEmployee.getCpf(), employee.getCpf()));
        }

        checkIsValidStatus(employee.getStatus());

        employee.setCreatedDate(oldEmployee.getCreatedDate());
        return employeeDataGateway.save(employee);
    }

    private void checkIsValidStatus(String status) {
        for (Status type : Status.values()){
            if(status.equals(type.getKey())) {
                return;
            }
        }

        throw new IllegalArgumentException(messageUtils.getMessage(MessageKey.STATUS_NOT_FOUND));
    }
}

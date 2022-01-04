package edu.unifacef.employee.usecases;

import edu.unifacef.employee.domains.Employee;
import edu.unifacef.employee.domains.Status;
import edu.unifacef.employee.exceptions.MessageKey;
import edu.unifacef.employee.gateways.outputs.EmployeeDataGateway;
import edu.unifacef.employee.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartialUpdate {

    private final EmployeeDataGateway employeeDataGateway;
    private final MessageUtils messageUtils;

    public Employee execute(final Employee employee) {
        log.info("Partial updating employee. Employee id: {}", employee.getId());

        Employee oldEmployee = employeeDataGateway.findById(employee.getId())
                .orElseThrow(() -> new IllegalArgumentException(messageUtils
                        .getMessage(MessageKey.EMPLOYEE_NOT_FOUND, employee.getId())));

        if(!Objects.isNull(employee.getName())) {
            oldEmployee.setName(employee.getName());
        }

        if(employee.getSalary() != 0) {
            oldEmployee.setSalary(employee.getSalary());
        }

        if(!Objects.isNull(employee.getFunction())) {
            oldEmployee.setFunction(employee.getFunction());
        }

        if(!Objects.isNull(employee.getStatus())) {
            checkIsValidStatus(employee.getStatus());

            if(oldEmployee.getStatus().equals(employee.getStatus())) {
                throw new IllegalArgumentException(messageUtils
                        .getMessage(MessageKey.STATUS_ALREADY_SET, employee.getId()));
            }

            oldEmployee.setStatus(employee.getStatus());

            if(oldEmployee.getStatus().equals(Status.FIRED.getKey()) &&
            Objects.isNull(oldEmployee.getDeletedAt())){
                oldEmployee.setDeletedAt(LocalDateTime.now());
            }
        }

        oldEmployee.setLastModifiedDate(LocalDateTime.now());
        return employeeDataGateway.save(oldEmployee);
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

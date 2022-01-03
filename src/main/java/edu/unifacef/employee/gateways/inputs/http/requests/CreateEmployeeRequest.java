package edu.unifacef.employee.gateways.inputs.http.requests;

import edu.unifacef.employee.domains.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateEmployeeRequest extends EmployeeRequest{
    private static final long serialVersionUID = 8743997776881612716L;

    public Employee toDomain() {
        return Employee.builder()
                .name(super.getName())
                .birthday(super.getBirthday())
                .cpf(super.getCpf())
                .salary(super.getSalary())
                .function(super.getFunction())
                .status(super.getStatus())
                .build();
    }
}

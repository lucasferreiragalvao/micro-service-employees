package edu.unifacef.employee.gateways.inputs.http.requests;

import edu.unifacef.employee.domains.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateEmployeeRequest extends EmployeeRequest{
    private static final long serialVersionUID = 3243997376821623716L;

    public Employee toDomain(String id) {
        return Employee.builder()
                .id(id)
                .name(super.getName())
                .birthday(super.getBirthday())
                .cpf(super.getCpf())
                .salary(super.getSalary())
                .function(super.getFunction())
                .status(super.getStatus())
                .build();
    }
}

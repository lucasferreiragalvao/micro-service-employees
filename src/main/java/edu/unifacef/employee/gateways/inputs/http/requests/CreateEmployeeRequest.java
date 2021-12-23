package edu.unifacef.employee.gateways.inputs.http.requests;

import edu.unifacef.employee.domains.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateEmployeeRequest extends EmployeeRequest{
    private static final long serialVersionUID = 8743997776881612716L;

    @NotNull(message = "{required.field}")
    private String id;

    public Employee toDomain() {
        return Employee.builder()
                .id(this.id)
                .name(super.getName())
                .birthday(super.getBirthday())
                .cpf(super.getCpf())
                .salary(super.getSalary())
                .function(super.getFunction())
                .status(super.getStatus())
                .build();
    }
}

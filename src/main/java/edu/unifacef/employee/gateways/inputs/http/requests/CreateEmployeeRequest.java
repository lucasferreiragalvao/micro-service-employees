package edu.unifacef.employee.gateways.inputs.http.requests;

import edu.unifacef.employee.domains.Address;
import edu.unifacef.employee.domains.Employee;
import edu.unifacef.employee.domains.Phone;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateEmployeeRequest extends EmployeeRequest{
    private static final long serialVersionUID = 8743997776881612716L;

    public Employee toDomain() {
        List<Address> listAddress = super.getAddress()
                .stream().map(addressRequest -> addressRequest.toDomain()).collect(Collectors.toList());

        List<Phone> listPhone = super.getPhone()
                .stream().map(phoneRequest -> phoneRequest.toDomain()).collect(Collectors.toList());

        return Employee.builder()
                .name(super.getName())
                .birthday(super.getBirthday())
                .cpf(super.getCpf())
                .salary(super.getSalary())
                .function(super.getFunction())
                .status(super.getStatus())
                .addresses(listAddress)
                .phones(listPhone)
                .build();
    }
}

package edu.unifacef.employee.gateways.outputs.mongodb.documents;

import edu.unifacef.employee.domains.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document("employees")
public class EmployeeDocument {

    @Id
    private String id;
    private String name;
    private String birthday;
    private String cpf;
    private Double salary;
    private String function;
    private String status;
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    private LocalDateTime deletedAt;

    public EmployeeDocument(final Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.birthday = employee.getBirthday();
        this.cpf = employee.getCpf();
        this.salary = employee.getSalary();
        this.function = employee.getFunction();
        this.status = employee.getStatus();
        this.createdDate = employee.getCreatedDate();
        this.lastModifiedDate = employee.getLastModifiedDate();
        this.deletedAt = employee.getDeletedAt();
    }

    public Employee toDomain() {
        return Employee.builder()
                .id(this.id)
                .name(this.name)
                .birthday(this.birthday)
                .cpf(this.cpf)
                .salary(this.salary)
                .function(this.function)
                .status(this.status)
                .createdDate(this.createdDate)
                .lastModifiedDate(this.lastModifiedDate)
                .deletedAt(this.deletedAt)
                .build();
    }

}

package edu.unifacef.employee.domains;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Employee {

    private String id;
    private String name;
    private String birthday;
    private String cpf;
    private double salary;
    private String function;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private LocalDateTime deletedAt;

}

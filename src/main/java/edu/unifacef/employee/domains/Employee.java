package edu.unifacef.employee.domains;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

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
    private List<Address> addresses;
    private List<Phone> phones;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private LocalDateTime deletedAt;

}

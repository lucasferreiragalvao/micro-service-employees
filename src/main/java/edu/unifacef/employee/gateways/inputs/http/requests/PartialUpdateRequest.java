package edu.unifacef.employee.gateways.inputs.http.requests;

import edu.unifacef.employee.domains.Employee;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PartialUpdateRequest implements Serializable {
    private static final long serialVersionUID = 3865582069743912406L;

    @ApiModelProperty(position = 1)
    private String name;

    @ApiModelProperty(position = 2)
    private double salary;

    @ApiModelProperty(position = 3)
    private String function;

    @ApiModelProperty(position = 4)
    private String status;

    public Employee toDomain(String id) {
        return Employee.builder()
                .id(id)
                .name(this.getName())
                .salary(this.getSalary())
                .function(this.getFunction())
                .status(this.getStatus())
                .build();
    }

}

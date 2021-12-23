package edu.unifacef.employee.gateways.inputs.http.requests;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public abstract class EmployeeRequest implements Serializable {

    private static final long serialVersionUID = 3475925051912891191L;

    @ApiModelProperty(position = 1)
    @NotNull(message = "{required.field}")
    private String name;

    @ApiModelProperty(position = 2)
    @NotNull(message = "{required.field}")
    private String birthday;

    @ApiModelProperty(position = 3)
    @NotNull(message = "{required.field}")
    private String cpf;

    @ApiModelProperty(position = 4)
    private double salary;

    @ApiModelProperty(position = 5)
    @NotNull(message = "{required.field}")
    private String function;

    @ApiModelProperty(position = 6)
    @NotNull(message = "{required.field}")
    private String status;


}

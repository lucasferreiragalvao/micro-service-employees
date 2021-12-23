package edu.unifacef.employee.gateways.inputs.http.responses;

import edu.unifacef.employee.domains.Employee;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class EmployeeResponse implements Serializable {

  private static final long serialVersionUID = 9189520552888285200L;

  @ApiModelProperty(position = 0)
  private String id;

  @ApiModelProperty(position = 1)
  private String name;

  @ApiModelProperty(position = 2)
  private String birthday;

  @ApiModelProperty(position = 3)
  private String cpf;

  @ApiModelProperty(position = 4)
  private Double salary;

  @ApiModelProperty(position = 5)
  private String function;

  @ApiModelProperty(position = 6)
  private String status;

  @ApiModelProperty(position = 7)
  private LocalDateTime createdDate;

  @ApiModelProperty(position = 8)
  private LocalDateTime lastModifiedDate;

  public EmployeeResponse(final Employee employee) {
    this.id = employee.getId();
    this.name = employee.getName();
    this.birthday = employee.getBirthday();
    this.cpf = employee.getCpf();
    this.salary = employee.getSalary();
    this.function = employee.getFunction();
    this.status = employee.getStatus();
    this.createdDate = employee.getCreatedDate();
    this.lastModifiedDate = employee.getLastModifiedDate();
  }

}
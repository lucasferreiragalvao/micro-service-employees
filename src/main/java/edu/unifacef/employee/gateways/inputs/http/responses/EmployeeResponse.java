package edu.unifacef.employee.gateways.inputs.http.responses;

import edu.unifacef.employee.domains.Address;
import edu.unifacef.employee.domains.Employee;
import edu.unifacef.employee.domains.Phone;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
  private List<Address> addresses;

  @ApiModelProperty(position = 8)
  private List<Phone> phones;

  @ApiModelProperty(position = 9)
  private LocalDateTime createdDate;

  @ApiModelProperty(position = 10)
  private LocalDateTime lastModifiedDate;

  @ApiModelProperty(position = 11)
  private LocalDateTime deletedAt;

  public EmployeeResponse(final Employee employee) {
    this.id = employee.getId();
    this.name = employee.getName();
    this.birthday = employee.getBirthday();
    this.cpf = employee.getCpf();
    this.salary = employee.getSalary();
    this.function = employee.getFunction();
    this.status = employee.getStatus();
    this.addresses = employee.getAddresses();
    this.phones = employee.getPhones();
    this.createdDate = employee.getCreatedDate();
    this.lastModifiedDate = employee.getLastModifiedDate();
    this.deletedAt = employee.getDeletedAt();
  }

}

package edu.unifacef.employee.gateways.inputs.http.requests;

import edu.unifacef.employee.domains.Phone;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PhoneRequest implements Serializable {

    private static final long serialVersionUID = -6340735326562084341L;

    @ApiModelProperty(position = 1)
    @NotNull(message = "{required.field}")
    private String ddi;

    @ApiModelProperty(position = 2)
    @NotNull(message = "{required.field}")
    private String ddd;

    @ApiModelProperty(position = 3)
    @NotNull(message = "{required.field}")
    private String phoneNumber;

    public Phone toDomain() {
        return Phone.builder()
                .ddi(this.ddi)
                .ddd(this.ddd)
                .phoneNumber(this.phoneNumber)
                .build();
    }
}

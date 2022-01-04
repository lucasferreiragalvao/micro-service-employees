package edu.unifacef.employee.gateways.inputs.http.requests;

import edu.unifacef.employee.domains.Address;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AddressRequest implements Serializable {
    private static final long serialVersionUID = 8443034175444152530L;

    @ApiModelProperty(position = 1)
    @NotNull(message = "{required.field}")
    private String state;

    @ApiModelProperty(position = 2)
    @NotNull(message = "{required.field}")
    private String city;

    @ApiModelProperty(position = 3)
    @NotNull(message = "{required.field}")
    private String postcode;

    @ApiModelProperty(position = 4)
    @NotNull(message = "{required.field}")
    private String neighborhood;

    @ApiModelProperty(position = 5)
    @NotNull(message = "{required.field}")
    private String streetName;

    @ApiModelProperty(position = 6)
    @NotNull(message = "{required.field}")
    private String streetNumber;

    @ApiModelProperty(position = 7)
    private String complement;

    public Address toDomain() {
        return Address.builder()
                .state(this.getState())
                .city(this.getCity())
                .postcode(this.getPostcode())
                .neighborhood(this.getNeighborhood())
                .streetName(this.getStreetName())
                .streetNumber(this.getStreetNumber())
                .complement(this.getComplement())
                .build();
    }
}

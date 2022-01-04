package edu.unifacef.employee.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String state;
    private String city;
    private String postcode;
    private String neighborhood;
    private String streetName;
    private String streetNumber;
    private String complement;
}

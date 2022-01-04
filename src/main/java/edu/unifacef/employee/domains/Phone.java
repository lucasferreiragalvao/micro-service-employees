package edu.unifacef.employee.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Phone {

    private String ddi;
    private String ddd;
    private String phoneNumber;

}

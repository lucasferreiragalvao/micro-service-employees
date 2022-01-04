package edu.unifacef.employee.gateways.outputs.mongodb.documents;

import edu.unifacef.employee.domains.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDocument {

    private String state;
    private String city;
    private String postcode;
    private String neighborhood;
    private String streetName;
    private String streetNumber;
    private String complement;

    public AddressDocument(final Address address) {
        this.state = address.getState();
        this.city = address.getCity();
        this.postcode = address.getPostcode();
        this.neighborhood = address.getNeighborhood();
        this.streetName = address.getStreetName();
        this.streetNumber = address.getStreetNumber();
        this.complement = address.getComplement();
    }

    public Address toDomain() {
        return Address.builder()
                .state(this.state)
                .city(this.city)
                .postcode(this.postcode)
                .neighborhood(this.neighborhood)
                .streetName(this.streetName)
                .streetNumber(this.streetNumber)
                .complement(this.complement)
                .build();
    }

}

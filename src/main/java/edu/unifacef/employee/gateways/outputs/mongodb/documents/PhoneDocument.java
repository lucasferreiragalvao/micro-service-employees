package edu.unifacef.employee.gateways.outputs.mongodb.documents;

import edu.unifacef.employee.domains.Phone;

public class PhoneDocument {
    private String ddi;
    private String ddd;
    private String phoneNumber;

    public PhoneDocument(final Phone address) {
        this.ddi = address.getDdi();
        this.ddd = address.getDdd();
        this.phoneNumber = address.getPhoneNumber();
    }

    public Phone toDomain() {
        return Phone.builder()
                .ddi(this.ddi)
                .ddd(this.ddd)
                .phoneNumber(this.phoneNumber)
                .build();
    }
}

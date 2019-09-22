package pl.lickerish.cashregistryspring.DTO;

import lombok.Builder;
import lombok.Data;

@Data
public class AddressDTO {

    private Integer id;
    private String street;
    private String city;
    private String zipCode;

    @Builder
    public AddressDTO(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
}

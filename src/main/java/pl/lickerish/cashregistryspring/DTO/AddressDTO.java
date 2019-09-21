package pl.lickerish.cashregistryspring.DTO;

import lombok.Data;

@Data
public class AddressDTO {

    private Integer id;
    private String street;
    private String city;
    private String zipCode;

}

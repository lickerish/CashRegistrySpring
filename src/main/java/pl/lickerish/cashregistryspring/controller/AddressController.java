package pl.lickerish.cashregistryspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.lickerish.cashregistryspring.DTO.AddressDTO;
import pl.lickerish.cashregistryspring.service.AddressService;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/create")
    public AddressDTO createAddress(@RequestParam String street, @RequestParam String city, @RequestParam String zipCode) {
        AddressDTO addressDTO = AddressDTO.builder()
                .street(street)
                .city(city)
                .zipCode(zipCode)
                .build();
        addressService.create(addressDTO);
        return addressDTO;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/createWithJSON")
    public AddressDTO createAddress(@RequestBody AddressDTO addressDTO) {
        addressService.create(addressDTO);
        return addressDTO;
    }
}

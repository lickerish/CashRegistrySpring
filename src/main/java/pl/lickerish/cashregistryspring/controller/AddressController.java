package pl.lickerish.cashregistryspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.lickerish.cashregistryspring.DTO.AddressDTO;
import pl.lickerish.cashregistryspring.model.Address;
import pl.lickerish.cashregistryspring.service.AddressService;

import java.util.List;
import java.util.Optional;

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
    public AddressDTO create(@RequestParam String street, @RequestParam String city, @RequestParam String zipCode) {
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
    public AddressDTO create(@RequestBody AddressDTO addressDTO) {
        addressService.create(addressDTO);
        return addressDTO;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/massCreate")
    public List<AddressDTO> create(@RequestBody List<AddressDTO> addresses) {
        addresses.forEach(address -> addressService.create(address));
        return addresses;
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/findById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Address> findById(@PathVariable Integer id) {
        return addressService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping(value = "/update/{id}")
    public Address update(@RequestBody AddressDTO addressDTO, @PathVariable Integer id) {
        return addressService.update(addressDTO, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping(value = "/update")
    public Address update(@RequestBody AddressDTO addressDTO) {
        return addressService.update(addressDTO, addressDTO.getId());
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        addressService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete")
    public void delete(@RequestBody List<Integer> ids) {
        ids.forEach(id -> addressService.deleteById(id));

    }

}

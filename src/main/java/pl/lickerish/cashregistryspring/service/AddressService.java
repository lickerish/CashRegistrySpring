package pl.lickerish.cashregistryspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lickerish.cashregistryspring.DTO.AddressDTO;
import pl.lickerish.cashregistryspring.model.Address;
import pl.lickerish.cashregistryspring.repository.AddressRepository;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address create(AddressDTO address) {
        return addressRepository.save(new Address(address.getId(), address.getStreet(), address.getCity(), address.getZipCode()));
    }
}

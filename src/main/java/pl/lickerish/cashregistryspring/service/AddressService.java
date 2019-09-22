package pl.lickerish.cashregistryspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lickerish.cashregistryspring.DTO.AddressDTO;
import pl.lickerish.cashregistryspring.model.Address;
import pl.lickerish.cashregistryspring.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

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

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Optional<Address> findById(Integer id) {
        return addressRepository.findById(id);
    }

    public Address update(AddressDTO newAddress, Integer id) {
        return addressRepository.findById(id)
                .map(address -> {
                    address.setCity(newAddress.getCity());
                    address.setZipCode(newAddress.getZipCode());
                    address.setStreet(newAddress.getStreet());
                    return addressRepository.save(address);
                })
                .orElseGet(() -> {
                    newAddress.setId(id);
                    return addressRepository.save(new Address(newAddress.getId(), newAddress.getStreet(), newAddress.getCity(), newAddress.getZipCode()));
                });
    }

    public void deleteById(Integer id) {
        addressRepository.deleteById(id);
    }
}

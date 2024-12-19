package tn.home.address.service;

import tn.home.address.entities.Address;

import java.util.Optional;

public interface AddressService {
    Address createAddress(Address address);
    Optional<Address> getAddressById(Long id);
}

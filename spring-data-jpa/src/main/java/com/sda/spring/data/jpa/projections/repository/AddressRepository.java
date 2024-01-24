package com.sda.spring.data.jpa.projections.repository;

import com.sda.spring.data.jpa.projections.view.AddressView;
import com.sda.spring.data.jpa.projections.model.Address;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AddressRepository extends Repository<Address, Long> {
    List<AddressView> getAddressByState(String state);
}

package com.quickbooks.quickbooks.repository;

import com.quickbooks.quickbooks.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}

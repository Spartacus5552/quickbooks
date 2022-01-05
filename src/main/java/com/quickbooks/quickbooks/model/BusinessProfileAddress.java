package com.quickbooks.quickbooks.model;


import com.quickbooks.quickbooks.enums.AddressType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="business_profile_address")
public class BusinessProfileAddress {

    private BusinessProfile businessProfile;
    private Address address;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

}

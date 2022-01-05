package com.quickbooks.quickbooks.model.dto;

import com.quickbooks.quickbooks.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessProfileDTO {

    private String companyName;
    private String legalName;
    private String PAN;
    private String email;
    private String website;
    private List<Address> businessAddress;
    private Address legalAddress;
}

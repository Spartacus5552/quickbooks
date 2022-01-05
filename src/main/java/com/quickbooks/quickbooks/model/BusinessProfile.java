package com.quickbooks.quickbooks.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="business_profile")
public class BusinessProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int businessId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "legal_name")
    private String LegalName;
    private String PAN;
    private String email;
    private String website;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "businessProfile")
    @Column(name = "business_address")
    private List<Address> businessAddress = new ArrayList<>();

    @Column(name = "legal_address")
    private Address legalAddress;*/
}

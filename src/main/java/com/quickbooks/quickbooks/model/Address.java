package com.quickbooks.quickbooks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int addressId;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id")
    @Column(name = "business_profile")
    private BusinessProfile businessProfile;*/

    private String location;
    private String city;
    private String state;
    private String zip;
    private String country;
}

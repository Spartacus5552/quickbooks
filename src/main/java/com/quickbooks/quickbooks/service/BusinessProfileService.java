package com.quickbooks.quickbooks.service;

import com.quickbooks.quickbooks.enums.AddressType;
import com.quickbooks.quickbooks.model.Address;
import com.quickbooks.quickbooks.model.BusinessProfile;
import com.quickbooks.quickbooks.model.BusinessProfileAddress;
import com.quickbooks.quickbooks.model.dto.BusinessProfileDTO;
import com.quickbooks.quickbooks.repository.AddressRepository;
import com.quickbooks.quickbooks.repository.BusinessProfileAddressRepository;
import com.quickbooks.quickbooks.repository.BusinessProfileRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BusinessProfileService {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    BusinessProfileRepository businessProfileRepository;
    @Autowired
    BusinessProfileAddressRepository businessProfileAddressRepository;
    @Autowired
    Mapper mapper;

    @Transactional
    public void save(BusinessProfileDTO businessProfileDTO) {
        //todo: parallel validation
        BusinessProfile businessProfile = mapper.map(businessProfileDTO, BusinessProfile.class);
        businessProfileRepository.save(businessProfile);
        saveAddress(businessProfileDTO, businessProfile);

    }

    private void saveAddress(BusinessProfileDTO businessProfileDTO, BusinessProfile businessProfile) {
        List<Address> addressList = businessProfileDTO.getBusinessAddress();
        for(Address address : addressList){
            addressRepository.save(address);
            saveBusinessProfileAddress(businessProfile, address, AddressType.BRANCH);
        }
        Address legalAddress = businessProfileDTO.getLegalAddress();
        addressRepository.save(legalAddress);
        saveBusinessProfileAddress(businessProfile, legalAddress, AddressType.LEGAL);

    }

    private void saveBusinessProfileAddress(BusinessProfile businessProfile, Address address, AddressType addressType){
        BusinessProfileAddress businessProfileAddress = new BusinessProfileAddress();
        businessProfileAddress.setBusinessProfile(businessProfile);
        businessProfileAddress.setAddress(address);
        businessProfileAddress.setAddressType(addressType);
        businessProfileAddressRepository.save(businessProfileAddress);
    }
}

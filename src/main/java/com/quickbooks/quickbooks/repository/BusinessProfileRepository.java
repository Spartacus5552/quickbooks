package com.quickbooks.quickbooks.repository;

import com.quickbooks.quickbooks.model.BusinessProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessProfileRepository extends JpaRepository<BusinessProfile, Integer> {

}

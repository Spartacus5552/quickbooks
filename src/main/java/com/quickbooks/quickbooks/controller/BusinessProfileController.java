package com.quickbooks.quickbooks.controller;


import com.quickbooks.quickbooks.model.dto.BusinessProfileDTO;
import com.quickbooks.quickbooks.repository.BusinessProfileRepository;
import com.quickbooks.quickbooks.service.BusinessProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/profile")
public class BusinessProfileController {

    @Autowired
    private BusinessProfileService businessProfileService;
    @Autowired
    private BusinessProfileRepository businessProfileRepository;

    @PostMapping("")
    ResponseEntity<?> create(@RequestBody BusinessProfileDTO businessProfileDTO) {
        try {
            businessProfileService.save(businessProfileDTO);
        } catch (Exception e){
            return new ResponseEntity<>("Profile Creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Profile Created Successfully", HttpStatus.CREATED);
    }
}

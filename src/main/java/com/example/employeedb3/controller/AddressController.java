package com.example.employeedb3.controller;

import com.example.employeedb3.dto.AddressFinalResponse;
import com.example.employeedb3.dto.AddressInjectionDto;
import com.example.employeedb3.dto.AddressRequestDto;
import com.example.employeedb3.dto.AddressResponseDto;
import com.example.employeedb3.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService service;


    @PostMapping("/addAddress")
    public AddressFinalResponse addAddress(@RequestBody AddressInjectionDto requestDto){
        return new AddressFinalResponse(false,"address added successfully",service.addAddress(requestDto));
    }
    @PutMapping("/updateAddress")
    public AddressFinalResponse updateAddress(@RequestBody AddressInjectionDto requestDto){
        return new AddressFinalResponse(false,"address updated successfully",service.updateAddress(requestDto));
    }
}

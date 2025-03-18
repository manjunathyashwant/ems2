package com.example.employeedb3.service;

import com.example.employeedb3.dto.AddressInjectionDto;
import com.example.employeedb3.dto.AddressResponseDto;
import com.example.employeedb3.entity.Address;

import java.util.List;

public interface AddressService {
    public List<AddressResponseDto> addAddress(AddressInjectionDto requestDto);

    public List<Address> updateAddress(AddressInjectionDto requestDto);
}

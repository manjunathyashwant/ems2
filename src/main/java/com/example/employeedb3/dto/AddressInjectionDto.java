package com.example.employeedb3.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;



public class AddressInjectionDto {
    private String email;
    private List<AddressRequestDto> addresses;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AddressRequestDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressRequestDto> addresses) {
        this.addresses = addresses;
    }
}

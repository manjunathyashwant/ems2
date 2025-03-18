package com.example.employeedb3.service;

import com.example.employeedb3.dto.AddressInjectionDto;
import com.example.employeedb3.dto.AddressRequestDto;
import com.example.employeedb3.dto.AddressResponseDto;
import com.example.employeedb3.entity.Address;
import com.example.employeedb3.entity.Employee;
import com.example.employeedb3.exception.EmployeeNotFoundException;
import com.example.employeedb3.repository.AddressRepo;
import com.example.employeedb3.repository.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private AddressRepo addressRepo;
    @Override
    public List<AddressResponseDto> addAddress(AddressInjectionDto requestDto) {
        Employee employee = employeeRepo.findByEmail(requestDto.getEmail()).orElseThrow(() -> new EmployeeNotFoundException("the given email dont exists"));
        
        List<AddressRequestDto> addresses = requestDto.getAddresses();
        List<Address> addressList = addresses.stream().map(requestDto1 -> {
            Address address = new Address();
            BeanUtils.copyProperties(requestDto1, address);
            address.setEmployee(employee);
            return address;
        }).toList();

        addressRepo.saveAll(addressList);
        List<AddressResponseDto> addressResponseDtos = addressList.stream().map(address -> {
            AddressResponseDto responseDto = new AddressResponseDto();
            BeanUtils.copyProperties(address, responseDto);
            return responseDto;
        }).toList();

        return addressResponseDtos;
    }

    @Override
    public List<Address> updateAddress(AddressInjectionDto requestDto) {
        Employee employee = employeeRepo.findByEmail(requestDto.getEmail()).orElseThrow(() -> new EmployeeNotFoundException("the given email don't exists"));
        List<Address> databaseAddress = addressRepo.findByEmployee(employee);
        List<AddressRequestDto> updatingAddresses = requestDto.getAddresses();
        for (int i = 0; i <databaseAddress.size() ; i++) {
            updatingAddresses.get(i).setId(databaseAddress.get(i).getId());
            BeanUtils.copyProperties(updatingAddresses.get(i),databaseAddress.get(i));
        }
        List<Address> addresses = addressRepo.saveAll(databaseAddress);

        return addresses ;
    }
}

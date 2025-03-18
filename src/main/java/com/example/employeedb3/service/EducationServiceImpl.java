package com.example.employeedb3.service;

import com.example.employeedb3.dto.EducationInjectionDto;
import com.example.employeedb3.dto.EducationRequestDto;
import com.example.employeedb3.dto.EducationResponseDto;
import com.example.employeedb3.entity.Address;
import com.example.employeedb3.entity.Education;
import com.example.employeedb3.entity.Employee;
import com.example.employeedb3.exception.EmployeeNotFoundException;
import com.example.employeedb3.repository.EducationRepo;
import com.example.employeedb3.repository.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EducationRepo educationRepo;


    public List<EducationResponseDto> addEducation(EducationInjectionDto requestDto) {
        Employee employee = employeeRepo.findByEmail(requestDto.getEmail()).orElseThrow(() -> new EmployeeNotFoundException("employee not present with the given email"));
        List<Education> educationList = requestDto.getEducationDetails().stream().map(educationRequestDto -> {
            Education education = new Education();
            BeanUtils.copyProperties(educationRequestDto, education);
            education.setEmployee(employee);
            return education;
        }).toList();
        List<Education> savedEducationList1 = educationRepo.saveAll(educationList);
        List<EducationResponseDto> educationResponseDtoList = savedEducationList1.stream().map(education -> {
            EducationResponseDto educationResponseDto = new EducationResponseDto();
            BeanUtils.copyProperties(education, educationResponseDto);
            return educationResponseDto;
        }).toList();

        return educationResponseDtoList;
    }

    @Override
    public List<Education> updateEducation(EducationInjectionDto requestDto) {
       // System.out.println(requestDto);

        Employee employee = employeeRepo.findByEmail(requestDto.getEmail()).orElseThrow(() -> new EmployeeNotFoundException("employee not present with the given email"));
        List<Education> databaseEducation = educationRepo.findByEmployee(employee);
        List<EducationRequestDto> updatedEducationDetails = requestDto.getEducationDetails();
        for (int i = 0; i < updatedEducationDetails.size(); i++) {
            updatedEducationDetails.get(i).setId(databaseEducation.get(i).getId());
            BeanUtils.copyProperties(updatedEducationDetails.get(i), databaseEducation.get(i));

        }
        List<Education> educationList = educationRepo.saveAll(databaseEducation);
        return educationList;
    }
}



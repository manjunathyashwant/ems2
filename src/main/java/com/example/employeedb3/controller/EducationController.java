package com.example.employeedb3.controller;

import com.example.employeedb3.dto.EducationInjectionDto;
import com.example.employeedb3.dto.QualificationResponseDto;
import com.example.employeedb3.service.EducationService;
import com.example.employeedb3.service.EducationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducationController {

    @Autowired
    private EducationService educationService;
    @PostMapping("/addEductaion")
    public QualificationResponseDto addEducation(@RequestBody EducationInjectionDto requestDto){

       return new QualificationResponseDto(false,"Qualification added successfully",educationService.addEducation(requestDto));
    }

    @PutMapping("/updateEducation")
    public QualificationResponseDto updateEdu(@RequestBody EducationInjectionDto requestDto){
        return new QualificationResponseDto(false,"Qualification updated successfully",educationService.updateEducation(requestDto));
    }
}

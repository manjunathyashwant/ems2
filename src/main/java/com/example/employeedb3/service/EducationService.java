package com.example.employeedb3.service;

import com.example.employeedb3.dto.EducationInjectionDto;
import com.example.employeedb3.dto.EducationResponseDto;
import com.example.employeedb3.entity.Education;

import java.util.List;

public interface EducationService {
    public List<EducationResponseDto> addEducation(EducationInjectionDto requestDto);

    List<Education> updateEducation(EducationInjectionDto requestDto);
}

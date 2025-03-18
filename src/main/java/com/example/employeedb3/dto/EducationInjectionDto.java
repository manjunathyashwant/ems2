package com.example.employeedb3.dto;

import java.util.List;

public class EducationInjectionDto {
    private String email;
    private List<EducationRequestDto> educationDetails;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<EducationRequestDto> getEducationDetails() {
        return educationDetails;
    }

    public void setEducationDetails(List<EducationRequestDto> educationDetails) {
        this.educationDetails = educationDetails;
    }

    @Override
    public String toString() {
        return "EducationInjectionDto{" +
                "email='" + email + '\'' +
                ", educationDetails=" + educationDetails +
                '}';
    }
}

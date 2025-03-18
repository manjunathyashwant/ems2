package com.example.employeedb3.dto;


import jakarta.validation.constraints.*;


import java.util.List;

public class EmployeeRequestDTO {

    private Integer empId;
    @NotBlank(message = "must enter the characters")
    @Size(min = 3,max = 30)
    private String empName;
    @Email
    private String email;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$" ,message = "password should contain atleast 8 characters,one special characters and must have upper and lower case alphabets")
    private String password;

//    private List<AddressRequestDto> address;
//    private List<EducationRequestDto> education;
//
//    public List<EducationRequestDto> getEducation() {
//        return education;
//    }
//
//    public void setEducation(List<EducationRequestDto> education) {
//        this.education = education;
//    }
//
//    public List<AddressRequestDto> getAddress() {
//        return address;
//    }
//
//    public void setAddress(List<AddressRequestDto> address) {
//        this.address = address;
//    }

    public Integer getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

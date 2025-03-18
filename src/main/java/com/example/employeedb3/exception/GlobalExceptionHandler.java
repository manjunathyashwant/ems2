package com.example.employeedb3.exception;

import com.example.employeedb3.dto.ResponseDTO;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler( EmployeeFoundException.class)
    public ResponseDTO employeeFoundException(EmployeeFoundException e){
        return new ResponseDTO(true,e.getMessage(),null);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseDTO employeeNotFoundException(EmployeeNotFoundException e){
        return new ResponseDTO(true,e.getMessage(),null);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseDTO invalidCredentials(InvalidCredentialsException e){
        return new ResponseDTO(true,e.getMessage(),null);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDTO validationFailed(MethodArgumentNotValidException e){
//        Map<String,String> map=new HashMap<>();
//        for (FieldError error:e.getBindingResult().getFieldErrors()){
//            map.put(error.getField(),error.getDefaultMessage());
//        }
//        return new ResponseDTO(true,"",map);
        List<String> strings=new ArrayList<>();
        for (FieldError error:e.getBindingResult().getFieldErrors()){
            strings.add(error.getField()+" "+error.getDefaultMessage());
        }
        String messages = String.join(",", strings);
        return new ResponseDTO(true,messages,null);
    }
}

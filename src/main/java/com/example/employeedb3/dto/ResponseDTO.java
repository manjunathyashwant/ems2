package com.example.employeedb3.dto;

import lombok.Getter;


public class ResponseDTO {
    private boolean error;
    private String message;
    private Object data;

    public ResponseDTO(boolean error, String message, Object data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}

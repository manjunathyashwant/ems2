package com.example.employeedb3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class AddressFinalResponse {
    private boolean error;
    private String message;
    private Object data;

    public AddressFinalResponse(boolean error, String message, Object data) {
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

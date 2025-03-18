package com.example.employeedb3.dto;

public class QualificationResponseDto {
    private boolean error;
    private String message;
    private Object data;

    public QualificationResponseDto(boolean error, String message, Object data) {
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

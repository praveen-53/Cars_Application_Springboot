package com.example.CRUD.model;

public class CommonResponse {
    private String message;

    public CommonResponse() {
    }

    public CommonResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}

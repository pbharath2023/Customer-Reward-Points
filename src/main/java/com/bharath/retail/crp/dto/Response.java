package com.bharath.retail.crp.dto;

public class Response<T> {
    private String status;
    private String message;
    private T data;

    public Response(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

}

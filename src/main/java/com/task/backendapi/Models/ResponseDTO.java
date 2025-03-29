package com.task.backendapi.Models;



public class ResponseDTO {

    private Object data;
    private String message;
    private boolean hasError;



    public ResponseDTO() {
    }


    public ResponseDTO(Object data, String message, boolean hasError) {
        this.data = data;
        this.message = message;
        this.hasError = hasError;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

}

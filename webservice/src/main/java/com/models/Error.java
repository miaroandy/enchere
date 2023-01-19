package com.models;

public class Error {

    private Object error;

    public Error(Exception e){
        this.setError(e);
    }

    public Object getError() {
        return error;
    }


    public void setError(Exception e) {
        this.error = e;
    }
}

package com.tm.tmnetwork.entity.base;

import java.util.ArrayList;

public class BaseErrorEntity {

    public ArrayList<TenantError> errors;

    public boolean success;

    public String Message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<TenantError> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<TenantError> errors) {
        this.errors = errors;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}

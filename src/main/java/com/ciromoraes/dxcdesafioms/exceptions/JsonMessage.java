package com.ciromoraes.dxcdesafioms.exceptions;

import java.util.Date;

public class JsonMessage {

    private String message;
    private Date timestamp;

    public JsonMessage(String message) {
        this.message = message;
        this.timestamp = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

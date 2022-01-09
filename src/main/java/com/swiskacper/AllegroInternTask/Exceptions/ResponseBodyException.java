package com.swiskacper.AllegroInternTask.Exceptions;

import java.time.LocalDateTime;

public class ResponseBodyException {
    private String status;
    private String message;
    private LocalDateTime localDateTime;

    public ResponseBodyException() {
    }

    public ResponseBodyException(String status, String message, LocalDateTime localDateTime) {
        this.status = status;
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

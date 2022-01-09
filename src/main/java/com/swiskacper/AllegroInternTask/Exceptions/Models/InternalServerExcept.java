package com.swiskacper.AllegroInternTask.Exceptions.Models;

public class InternalServerExcept extends ApiException {
    public InternalServerExcept(int code, String message) {
        super(code, message);
    }
}

package com.swiskacper.AllegroInternTask.Exceptions.Models;

public class SthNotFoundException extends ApiException {
    public  SthNotFoundException() {
        super(404,"Not found, went again!");
    }
}

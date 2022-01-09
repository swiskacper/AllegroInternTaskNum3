package com.swiskacper.AllegroInternTask.Exceptions.Models;

public class IncorrectNameException extends ApiException {
    public IncorrectNameException(){
        super(1,"Bad username. Your username should be between 1 and 39 characters.");
    }



}

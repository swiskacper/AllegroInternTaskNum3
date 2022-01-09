package com.swiskacper.AllegroInternTask.Exceptions.Models;

public class ClientErrorExcept extends ApiException {
    public ClientErrorExcept() {
        super(444, "Client error, something went wrong :(");
    }
}

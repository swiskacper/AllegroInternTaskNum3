package com.swiskacper.AllegroInternTask.Exceptions.Models;

public class ServerErrorExcept extends ApiException {
    public ServerErrorExcept() {
        super(505, "Server exception, something go wrong :(");
    }
}

package com.swiskacper.AllegroInternTask.Exceptions.Models;

public class ReqTimeoutException extends ApiException {
    public ReqTimeoutException() {
        super(408, "request to load a web page—took longer than the website's server was prepared to wait");
    }
}

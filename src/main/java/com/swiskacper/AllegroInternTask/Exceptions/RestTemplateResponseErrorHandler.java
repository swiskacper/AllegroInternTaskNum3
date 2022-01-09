package com.swiskacper.AllegroInternTask.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) {
        return true;
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {}


}

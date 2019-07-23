package org.holab.librarian.web.api.exception;

import javax.xml.crypto.Data;

public abstract class OpenApiException extends RuntimeException{
    public OpenApiException(String msg) {
        super(msg);
    }

    public OpenApiException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

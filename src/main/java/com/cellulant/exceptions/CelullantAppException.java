package com.cellulant.exceptions;
/**
 * 
 * @author Paul Msegeya
 */
public class CelullantAppException
        extends Exception {

    public CelullantAppException() {
    }

    public CelullantAppException(String message) {
        super(message);
    }

    public CelullantAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public CelullantAppException(Throwable cause) {
        super(cause);
    }

    public CelullantAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

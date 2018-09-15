package com.mobiquityinc.exception;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class InvalidMaxItemCountException extends APIException {

    public InvalidMaxItemCountException() {
    }

    public InvalidMaxItemCountException(String message) {
        super(message);
    }

    public InvalidMaxItemCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMaxItemCountException(Throwable cause) {
        super(cause);
    }

    public InvalidMaxItemCountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.mobiquityinc.exception;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class InvalidMaxPackWeightException extends APIException {

    public InvalidMaxPackWeightException() {
    }

    public InvalidMaxPackWeightException(String message) {
        super(message);
    }

    public InvalidMaxPackWeightException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMaxPackWeightException(Throwable cause) {
        super(cause);
    }

    public InvalidMaxPackWeightException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

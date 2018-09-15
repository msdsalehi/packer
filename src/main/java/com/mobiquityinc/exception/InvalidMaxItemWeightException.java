package com.mobiquityinc.exception;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class InvalidMaxItemWeightException extends APIException {

    public InvalidMaxItemWeightException() {
    }

    public InvalidMaxItemWeightException(String message) {
        super(message);
    }

    public InvalidMaxItemWeightException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMaxItemWeightException(Throwable cause) {
        super(cause);
    }

    public InvalidMaxItemWeightException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

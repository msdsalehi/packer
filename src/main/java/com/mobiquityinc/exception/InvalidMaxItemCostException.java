package com.mobiquityinc.exception;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class InvalidMaxItemCostException extends APIException {

    public InvalidMaxItemCostException() {
    }

    public InvalidMaxItemCostException(String message) {
        super(message);
    }

    public InvalidMaxItemCostException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMaxItemCostException(Throwable cause) {
        super(cause);
    }

    public InvalidMaxItemCostException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

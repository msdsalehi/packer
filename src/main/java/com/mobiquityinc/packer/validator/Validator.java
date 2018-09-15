package com.mobiquityinc.packer.validator;

import java.util.Collection;

/**
 * General validator for validating single objects and collections
 *
 * @author Masoud Salehi Alamdari
 */
public interface Validator<T> {

    /**
     * validate and object
     *
     * @param t
     */
    void validate(T t);

    /**
     * Validate a collection of objects
     *
     * @param t
     */
    void validateAll(Collection<T> t);
}

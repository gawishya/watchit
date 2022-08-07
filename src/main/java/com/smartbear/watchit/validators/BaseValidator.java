package com.smartbear.watchit.validators;

/**
 * BaseValidator is an upper structure for all validators on the system
 * to provide a well-defined & consistent structure
 */
public abstract class BaseValidator<T> {

    public boolean isValid(T t) throws Exception {

        return validate(t);
    }

    protected abstract boolean validate(T t) throws Exception;
}

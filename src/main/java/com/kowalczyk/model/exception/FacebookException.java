package com.kowalczyk.model.exception;

/**
 * Created by JKowalczyk on 2017-10-03.
 */
public class FacebookException extends Exception {

    public FacebookException(String message) {
        super(String.format("CANNOT CONNECT WITH FACEBOOK FOR APP [%s]", message));
    }
}

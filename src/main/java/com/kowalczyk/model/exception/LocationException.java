package com.kowalczyk.model.exception;

/**
 * Created by JKowalczyk on 2017-10-03.
 */
public class LocationException extends RuntimeException {

    public LocationException(String message) {
        super(String.format("CANNOT GET LOCATION FOR [%s]", message));
    }
}

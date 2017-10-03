package com.kowalczyk.controller;

import com.kowalczyk.model.exception.FacebookException;
import com.kowalczyk.model.exception.LocationException;
import com.kowalczyk.model.http.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;

/**
 * Created by JKowalczyk on 2017-06-21.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CentralControllerHandler {
    final static private Logger logger = LoggerFactory.getLogger(CentralControllerHandler.class);

    @InitBinder
    public void binder(WebDataBinder binder) {
        binder.registerCustomEditor(Timestamp.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
                setValue(new Timestamp(Long.parseLong(value)));
            }
        });
    }

    @ExceptionHandler({BindException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError bindException(BindException e, Locale locale) {
        List<ObjectError> allErrors = e.getAllErrors();
        ObjectError error = allErrors.get(0);
        logger.error(e.getMessage());
        return new ApiError(error.getDefaultMessage(), "BING_ERR");
    }

    @ExceptionHandler({LocationException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError methodArgumentNotValidException(LocationException e, Locale locale) {
        logger.error(e.getMessage());
        return new ApiError(String.format("%s: %s", e.getClass().getName(), e.getMessage() != null ? e.getMessage().trim() : ""), "REQUEST_LOCATION_NOT_VALID");
    }

    @ExceptionHandler({FacebookException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError exception(FacebookException e, Locale locale) {
        e.printStackTrace();
        return new ApiError(String.format("%s: %s", e.getClass().getName(), e.getMessage() != null ? e.getMessage().trim() : ""), "ERR_SERVER_FACEBOOK");
    }


}

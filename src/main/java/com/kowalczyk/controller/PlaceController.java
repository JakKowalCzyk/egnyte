package com.kowalczyk.controller;

import com.kowalczyk.model.http.ModelPlace;
import com.mashape.unirest.http.exceptions.UnirestException;
import facebook4j.FacebookException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by JKowalczyk on 2017-10-02.
 */
public interface PlaceController {

    @GetMapping(value = "/api/{country}/{city}/{place}")
    List<ModelPlace> getPlacesByCity(@PathVariable String country, @PathVariable String city, @PathVariable String place) throws UnirestException, FacebookException;

}

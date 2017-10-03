package com.kowalczyk.controller.impl;

import com.kowalczyk.controller.PlaceController;
import com.kowalczyk.model.http.ModelPlace;
import com.kowalczyk.service.PlaceService;
import com.mashape.unirest.http.exceptions.UnirestException;
import facebook4j.FacebookException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by JKowalczyk on 2017-10-02.
 */
@RestController
public class PlaceControllerImpl implements PlaceController {

    private PlaceService placeService;

    public PlaceControllerImpl(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Override
    public List<ModelPlace> getPlacesByCity(@PathVariable String country, @PathVariable String city, @PathVariable String place) throws UnirestException, FacebookException {
        return placeService.getPlacesByCity(country, city, place);
    }
}

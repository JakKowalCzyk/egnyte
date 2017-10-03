package com.kowalczyk.service;

import com.kowalczyk.model.http.ModelPlace;
import com.mashape.unirest.http.exceptions.UnirestException;
import facebook4j.FacebookException;

import java.util.List;

/**
 * Created by JKowalczyk on 2017-10-02.
 */
public interface PlaceService {

    List<ModelPlace> getPlacesByCity(String country, String city, String place) throws UnirestException, FacebookException;
}

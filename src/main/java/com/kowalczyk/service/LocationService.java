package com.kowalczyk.service;

import com.kowalczyk.model.maps.Location;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by JKowalczyk on 2017-10-03.
 */
public interface LocationService {

    Location getLocation(String country, String city) throws UnirestException;
}

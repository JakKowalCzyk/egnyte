package com.kowalczyk.service.impl;

import com.kowalczyk.model.exception.LocationException;
import com.kowalczyk.model.maps.AddressResults;
import com.kowalczyk.model.maps.GeoLocationResults;
import com.kowalczyk.model.maps.Location;
import com.kowalczyk.service.LocationService;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JKowalczyk on 2017-10-03.
 */
@Service
public class LocationServiceImpl implements LocationService {

    private static final String LOCATION_URL = "http://maps.googleapis.com/maps/api/geocode/json?address=";

    @Override
    public Location getLocation(String country, String city) throws UnirestException {
        List<AddressResults> addressResultsList = Unirest.get(getFormattedLocationUrl(country, city)).asObject(GeoLocationResults.class).getBody().getAddressResults();
        if (addressResultsList.isEmpty() || addressResultsList.size() > 1) {
            throw new LocationException(String.format("%s+%s", country, city));
        }
        return addressResultsList.stream().findFirst().get().getGeometry().getLocation();
    }

    private String getFormattedLocationUrl(String country, String city) {
        return String.format("%s%s+%s", LOCATION_URL, country, city);
    }
}

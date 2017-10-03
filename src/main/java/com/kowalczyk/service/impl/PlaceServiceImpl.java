package com.kowalczyk.service.impl;

import com.kowalczyk.model.graph.Token;
import com.kowalczyk.model.http.ModelPlace;
import com.kowalczyk.model.maps.Location;
import com.kowalczyk.service.LocationService;
import com.kowalczyk.service.PlaceService;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import facebook4j.*;
import facebook4j.auth.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JKowalczyk on 2017-10-02.
 */
@Service
public class PlaceServiceImpl implements PlaceService {

    private static final String GRAPH_TOKEN = "https://graph.facebook.com/oauth/access_token?";
    private static final String CLIENT_ID = "client_id";
    private static final String SECRET = "client_secret";
    private static final String GRANT_TYPE = "client_credentials";
    private static final String GRANT = "grant_type";
    private static final String NAME_FIELD = "name";
    private static final String LOCATION_FIELD = "location";
    private static final int DISTANCE_VALUE = 5000;

    @Value("${spring.social.facebook.appId}")
    private String clientId;
    @Value("${spring.social.facebook.appSecret}")
    private String secret;

    @Autowired
    private LocationService locationService;

    @Override
    public List<ModelPlace> getPlacesByCity(String country, String city, String place) throws UnirestException, FacebookException {
        Location location = locationService.getLocation(country, city);
        ResponseList<Place> places = getFacebookInstance().searchPlaces(place, new GeoLocation(location.getLat(), location.getLng()), DISTANCE_VALUE, new Reading().fields(NAME_FIELD, LOCATION_FIELD));
        return places.stream().map(this::getPlaces).collect(Collectors.toList());
    }

    private ModelPlace getPlaces(Place graphPlace) {
        ModelPlace modelPlace = new ModelPlace();
        modelPlace.setName(graphPlace.getName());
        modelPlace.setLatitude(Float.valueOf(graphPlace.getLocation().getLatitude().toString()));
        modelPlace.setLongitude(Float.valueOf(graphPlace.getLocation().getLongitude().toString()));
        return modelPlace;
    }

    public Facebook getFacebookInstance() throws UnirestException {
        Token token = Unirest.get(getTokenUrl()).asObject(Token.class).getBody();
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId(clientId, secret);
        facebook.setOAuthAccessToken(new AccessToken(token.getAccessToken(), null));
        return facebook;
    }

    private String getTokenUrl() {
        return String.format("%s%s=%s&%s=%s&%s=%s", GRAPH_TOKEN, CLIENT_ID, clientId, SECRET, secret, GRANT, GRANT_TYPE);
    }
}

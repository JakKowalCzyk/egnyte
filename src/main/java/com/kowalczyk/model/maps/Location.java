package com.kowalczyk.model.maps;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kowalczyk.model.GenericHttpModel;

/**
 * Created by JKowalczyk on 2017-10-03.
 */
public class Location extends GenericHttpModel {

    @JsonProperty("lat")
    private float lat;
    @JsonProperty("lng")
    private float lng;

    public Location() {
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }
}

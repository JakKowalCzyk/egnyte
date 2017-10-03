package com.kowalczyk.model.maps;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kowalczyk.model.GenericHttpModel;

/**
 * Created by JKowalczyk on 2017-10-03.
 */
public class Geometry extends GenericHttpModel {

    @JsonProperty("location")
    private Location location;

    public Geometry() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

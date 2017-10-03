package com.kowalczyk.model.maps;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kowalczyk.model.GenericHttpModel;

/**
 * Created by JKowalczyk on 2017-10-03.
 */
public class AddressResults extends GenericHttpModel {

    @JsonProperty("geometry")
    private Geometry geometry;

    public AddressResults() {
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}

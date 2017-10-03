package com.kowalczyk.model.http;

import com.kowalczyk.model.GenericHttpModel;

/**
 * Created by JKowalczyk on 2017-10-02.
 */

public class ModelPlace extends GenericHttpModel {

    private String name;
    private float latitude;
    private float longitude;

    public ModelPlace() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}

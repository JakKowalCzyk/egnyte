package com.kowalczyk.model.maps;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kowalczyk.model.GenericHttpModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JKowalczyk on 2017-10-03.
 */

public class GeoLocationResults extends GenericHttpModel {
    @JsonProperty("results")
    private List<AddressResults> addressResults = new ArrayList<>();

    public GeoLocationResults() {
    }

    public List<AddressResults> getAddressResults() {
        return addressResults;
    }

    public void setAddressResults(List<AddressResults> addressResults) {
        this.addressResults = addressResults;
    }
}

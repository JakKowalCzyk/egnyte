package com.kowalczyk.model.graph;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kowalczyk.model.GenericHttpModel;

/**
 * Created by JKowalczyk on 2017-10-03.
 */
public class Token extends GenericHttpModel {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;

    public Token() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}

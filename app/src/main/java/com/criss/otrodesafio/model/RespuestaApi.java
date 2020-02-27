package com.criss.otrodesafio.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RespuestaApi {

    @SerializedName("response_code")
    private int responseCode;
    private List<Result> results;


    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}

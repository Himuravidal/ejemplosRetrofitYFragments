package com.criss.otrodesafio.api;

import com.criss.otrodesafio.model.RespuestaApi;
import com.criss.otrodesafio.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("api.php?amount=1&category=18&difficulty=medium&type=boolean")
    Call<RespuestaApi> getQuestion();

}

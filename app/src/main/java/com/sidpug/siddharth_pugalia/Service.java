package com.sidpug.siddharth_pugalia;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {
    @GET("data/2.5/weather?lat={lat}&lon={lon}&appid={weather_key}")
    Call<JsonObject> getMinData(@Path("lat") String lat,
                                @Path("lon") String lon,
                                @Path("weather_key") String weather_key);
}


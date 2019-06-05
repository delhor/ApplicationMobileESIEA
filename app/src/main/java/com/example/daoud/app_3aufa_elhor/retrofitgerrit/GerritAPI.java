package com.example.daoud.app_3aufa_elhor.retrofitgerrit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface GerritAPI {

        @GET("all")
        Call<List<Country>> loadChanges(@Query("q") String status);
}


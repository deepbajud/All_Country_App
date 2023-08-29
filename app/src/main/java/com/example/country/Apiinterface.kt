package com.example.country

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {

    @GET("all")
    fun getcountry(): Call<List<CountryModal>>
}
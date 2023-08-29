package com.example.country

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class Apiclient {

    companion object {


        val BASE_URL = "https://restcountries.com/v2/"
        lateinit var retrofit: Retrofit

        fun getApiclient(): Retrofit {

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }
}
package com.iitkgp.weatherapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    //https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
    companion object{
        var baseurl="https://api.openweathermap.org/data/2.5/"

        fun getRetrofit() :Retrofit
        {
                return Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}
package com.iitkgp.weatherapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("weather")
    fun getdata( @Query("q")city:String,
                 @Query("appid")key:String
    ): Call<ResponseModel>




}
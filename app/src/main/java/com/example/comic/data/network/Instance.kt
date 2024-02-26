package com.example.comic.data.network

import com.example.comic.data.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Instance {

    private const val URL_BASE = "https://xkcd.com/"


    val retrofitService : ApiService by lazy {
        getRetrofit().create(ApiService::class.java)
    }



    private fun getRetrofit() : Retrofit = Retrofit
        .Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
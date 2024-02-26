package com.example.comic.data.service

import com.example.comic.data.model.ComicResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("{idComic}/info.0.json")
    suspend fun dameComic(@Path("idComic") idComic: Int): Response<ComicResponse>

}
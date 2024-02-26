package com.example.comic.data.service

import android.util.Log
import com.example.comic.data.model.ComicResponse
import com.example.comic.data.network.Instance
import retrofit2.Response

class ComicService {

    suspend fun getComic(): ComicResponse?{

        val id : Int = (0 until 1000).random()
        val response: Response<ComicResponse> = Instance.retrofitService.dameComic(id)
        if(!response.isSuccessful){
            showError()
        }
        return response.body()
    }

    private fun showError() {
        Log.i("TAG-ERROR", "Error en GET")

    }
}
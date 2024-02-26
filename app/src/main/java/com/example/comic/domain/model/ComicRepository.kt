package com.example.comic.domain.model

import com.example.comic.data.model.ComicResponse
import com.example.comic.data.service.ComicService

class ComicRepository {
    private val comicService = ComicService()

    suspend fun getComic(): Comics?{
        val response : ComicResponse? = comicService.getComic()
        if (response != null)
            return Comics(response.img, response.title)
        return null
    }
}
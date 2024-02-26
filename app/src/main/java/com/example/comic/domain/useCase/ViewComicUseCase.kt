package com.example.comic.domain.useCase

import com.example.comic.domain.model.ComicRepository
import com.example.comic.domain.model.Comics

class ViewComicUseCase {
    private val comicRepository = ComicRepository()

    suspend operator fun invoke(): Comics? = comicRepository.getComic()


}
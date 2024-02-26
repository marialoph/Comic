package com.example.comic.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comic.domain.model.Comics
import com.example.comic.domain.useCase.ViewComicUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ComicViewModel : ViewModel(){
    var comicLiveData  = MutableLiveData<Comics>()
    var progressBarLiveData =  MutableLiveData<Boolean>()
    val useCase = ViewComicUseCase()




    public fun searchByComic(){
        viewModelScope.launch {
            progressBarLiveData.postValue(true)
            delay(500)
            val nuevoComic = useCase()
            if (nuevoComic != null)
                comicLiveData.value = nuevoComic!!
            progressBarLiveData.postValue(false)


        }
    }
}
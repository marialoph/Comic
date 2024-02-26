package com.example.comic.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ComicResponse (){
    @SerializedName("img")
    @Expose
    var img: String=""

    @SerializedName("title")
    @Expose
    var title: String =""


}
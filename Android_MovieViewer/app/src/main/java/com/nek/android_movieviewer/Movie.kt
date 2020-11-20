package com.nek.testmovies

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Title")
    val name:String
)

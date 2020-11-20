package com.nek.testmovies

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("Search") //the json object property containing data
    val movies: List<Movie>
)

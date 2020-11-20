package com.nek.testmovies

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Omdb {
    @GET("/") //follows the path
    //gets parameters as @Query value from the data
    //the function can return in the future
    suspend fun getAllMovies(
        @Query("s") search: String,
        @Query("apiKey") apiKey: String = "fc2715c0"
    ): Response<MovieResponse>
}

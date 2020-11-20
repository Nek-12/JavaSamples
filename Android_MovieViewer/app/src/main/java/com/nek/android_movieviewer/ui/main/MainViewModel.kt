package com.nek.android_movieviewer.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.nek.testmovies.Movie
import com.nek.testmovies.Omdb
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    val movieData: MutableLiveData<List<Movie>> = MutableLiveData()

    init {
        val rf = Retrofit.Builder()
            .baseUrl("http://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
        val api = rf.create(Omdb::class.java)

        viewModelScope.launch {
            val res = api.getAllMovies("inception")
            res.body()?.movies?.let {
                movieData.postValue(it)
            }
        }


    }
}

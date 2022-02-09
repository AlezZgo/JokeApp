package com.example.jokeapp

import com.example.jokeapp.data.JokeServerModel
import retrofit2.Call
import retrofit2.http.GET

interface JokeService {

    @GET(JOKE_URL)
    fun getJoke() : Call<JokeServerModel>

    private companion object{
        const val JOKE_URL = "https://v2.jokeapi.dev/joke/Any?format=json"
    }
}


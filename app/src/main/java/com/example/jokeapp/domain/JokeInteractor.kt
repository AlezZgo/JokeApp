package com.example.jokeapp.domain

interface JokeInteractor {

    suspend fun getJoke(): Joke

    suspend fun changeFavourites(): Joke
}
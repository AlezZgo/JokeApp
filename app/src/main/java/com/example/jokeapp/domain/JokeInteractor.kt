package com.example.jokeapp.domain

import com.example.jokeapp.models.Joke

interface JokeInteractor {

    suspend fun getJoke(): Joke

    suspend fun changeFavourites() : Joke
}
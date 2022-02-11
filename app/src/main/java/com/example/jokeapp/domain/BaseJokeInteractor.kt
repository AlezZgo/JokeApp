package com.example.jokeapp.domain

import com.example.jokeapp.models.Joke

class BaseJokeInteractor : JokeInteractor {
    override suspend fun getJoke(): Joke {
        TODO("Not yet implemented")
    }

    override suspend fun changeFavourites(): Joke {
        TODO("Not yet implemented")
    }
}
package com.example.jokeapp.data.cache.cachedJoke

import com.example.jokeapp.data.ChangeJokeStatus
import com.example.jokeapp.data.JokeDataModel

interface ChangeJoke {
    suspend fun change(changeJokeStatus: ChangeJokeStatus): JokeDataModel

    class Empty : ChangeJoke {
        override suspend fun change(changeJokeStatus: ChangeJokeStatus): JokeDataModel {
            throw IllegalStateException("Empty change joke called")
        }
    }
}

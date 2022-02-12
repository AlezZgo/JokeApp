package com.example.jokeapp.data.cache.cachedJoke

import com.example.jokeapp.data.ChangeJokeStatus
import com.example.jokeapp.data.JokeDataModel
import java.lang.IllegalStateException

class Empty : ChangeJoke {
    override suspend fun change(changeJokeStatus: ChangeJokeStatus): JokeDataModel {
        throw IllegalStateException("Empty change joke called")
    }
}
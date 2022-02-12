package com.example.jokeapp.data.cache.cachedJoke

import com.example.jokeapp.data.ChangeJokeStatus
import com.example.jokeapp.data.JokeDataModel

class BaseCachedJoke : CachedJoke {
    private var cached: ChangeJoke = ChangeJoke.Empty()
    override fun saveJoke(joke: JokeDataModel) {
        cached = joke
    }

    override fun clear() {
        cached = ChangeJoke.Empty()
    }

    override suspend fun change(changeJokeStatus: ChangeJokeStatus): JokeDataModel {
        return cached.change(changeJokeStatus)
    }
}
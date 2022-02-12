package com.example.jokeapp.data.cache.cachedJoke

import com.example.jokeapp.data.JokeDataModel

interface CachedJoke : ChangeJoke {
    fun saveJoke(joke: JokeDataModel)
    fun clear()
}
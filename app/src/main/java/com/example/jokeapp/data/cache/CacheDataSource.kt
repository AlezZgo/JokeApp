package com.example.jokeapp.data.cache

import com.example.jokeapp.data.cloud.JokeServerModel
import com.example.jokeapp.domain.Joke

interface CacheDataSource {

    fun addOrRemove(id: Int, joke: JokeServerModel): Joke


}
package com.example.jokeapp.data

import com.example.jokeapp.models.Joke

interface CacheDataSource {

    fun addOrRemove(id: Int, joke: JokeServerModel): Joke


}
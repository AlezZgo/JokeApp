package com.example.jokeapp.data

interface JokeDataFetcher {
    suspend fun getJoke(): JokeDataModel
}

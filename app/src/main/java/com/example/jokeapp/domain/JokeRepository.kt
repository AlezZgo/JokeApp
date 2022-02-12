package com.example.jokeapp.domain

import com.example.jokeapp.data.JokeDataModel

interface JokeRepository {
    suspend fun getJoke(): JokeDataModel
    suspend fun changeJokeStatus(): JokeDataModel
    fun chooseDataSource(cached: Boolean)
}
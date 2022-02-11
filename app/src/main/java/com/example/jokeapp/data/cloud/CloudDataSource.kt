package com.example.jokeapp.data.cloud

interface CloudDataSource {

    fun getJoke(callback: JokeCloudCallback)
}
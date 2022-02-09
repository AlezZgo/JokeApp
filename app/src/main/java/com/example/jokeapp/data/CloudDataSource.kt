package com.example.jokeapp.data

interface CloudDataSource {

    fun getJoke(callback: JokeCloudCallback)
}
package com.example.jokeapp.data.cloud

interface JokeCloudCallback {

    fun provide(joke: JokeServerModel)
    fun fail(error: ErrorType)
}

enum class ErrorType {
    NO_CONNECTION,
    SERVICE_UNAVAILABLE
}

package com.example.jokeapp

import com.example.jokeapp.data.JokeDto

interface JokeService {

    fun getJoke(callBack: ServiceCallback)
}

interface ServiceCallback {
    fun returnSuccess(dto: JokeDto)

    fun returnError(type : ErrorType)

}

enum class ErrorType {
    NO_CONNECTION,
    OTHER
}

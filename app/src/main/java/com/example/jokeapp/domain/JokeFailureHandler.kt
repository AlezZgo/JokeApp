package com.example.jokeapp.domain

import com.example.jokeapp.domain.Errors.JokeFailure
import java.lang.Exception

interface JokeFailureHandler {
    fun handle(e: Exception) : JokeFailure
}
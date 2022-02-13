package com.example.jokeapp.domain

import com.example.jokeapp.domain.Errors.JokeFailure

interface JokeFailureHandler {
    fun handle(e: Exception): JokeFailure
}
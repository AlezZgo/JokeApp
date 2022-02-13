package com.example.jokeapp.domain

import com.example.jokeapp.core.resources.ResourceManager
import com.example.jokeapp.domain.Errors.GenericError
import com.example.jokeapp.domain.Errors.NoCachedJokes
import com.example.jokeapp.domain.Errors.NoConnection
import com.example.jokeapp.domain.Errors.ServiceUnavailable
import com.example.jokeapp.domain.exceptions.NoCachedJokesException
import com.example.jokeapp.domain.exceptions.NoConnectionException
import com.example.jokeapp.domain.exceptions.ServiceUnavailableException

class JokeFailureFactory(private val resourceManager: ResourceManager) : JokeFailureHandler {
    override fun handle(e: Exception) = when (e) {
        is NoConnectionException -> NoConnection(resourceManager)
        is NoCachedJokesException -> NoCachedJokes(resourceManager)
        is ServiceUnavailableException -> ServiceUnavailable(resourceManager)
        else -> GenericError(resourceManager)
    }
}
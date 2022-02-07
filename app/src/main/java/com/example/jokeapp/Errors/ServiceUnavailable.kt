package com.example.jokeapp.Errors

import com.example.jokeapp.R
import com.example.jokeapp.resources.ResourceManager

class ServiceUnavailable(private val resourceManager : ResourceManager) : JokeFailure {
    override fun getMessage(): String = resourceManager.getString(R.string.service_unavailable)
}
package com.example.jokeapp.Errors

import com.example.jokeapp.R
import com.example.jokeapp.resources.ResourceManager

class NoConnection(private val resourceManager : ResourceManager) : JokeFailure {
    override fun getMessage(): String = resourceManager.getString(R.string.no_conn)
}
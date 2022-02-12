package com.example.jokeapp.domain.Errors

import com.example.jokeapp.R
import com.example.jokeapp.core.resources.ResourceManager

class ServiceUnavailable(resourceManager: ResourceManager) : BaseJokeFailure(resourceManager) {
    override fun getMessageResId(): Int = R.string.service_unavailable
}
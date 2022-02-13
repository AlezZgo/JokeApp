package com.example.jokeapp.domain.Errors

import com.example.jokeapp.R
import com.example.jokeapp.core.resources.ResourceManager

class GenericError(resourceManager: ResourceManager) : BaseJokeFailure(resourceManager) {
    override fun getMessageResId() = R.string.generic_fail_message
}
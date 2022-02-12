package com.example.jokeapp.domain.Errors

import com.example.jokeapp.core.resources.ResourceManager

abstract class BaseJokeFailure(private val resourceManager: ResourceManager) : JokeFailure {
    @StringRes
    protected abstract fun getMessageResId(): Int

    override fun getMessage() = resourceManager.getString(getMessageResId())

}
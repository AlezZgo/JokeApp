package com.example.jokeapp.domain

import androidx.annotation.DrawableRes
import com.example.jokeapp.models.DataCallBack

abstract class Joke(private val text: String, private val punchline: String) {

    protected fun getJokeUi() = "$text\n$punchline"

    @DrawableRes
    protected abstract fun getIconResId() : Int

    fun map(callBack: DataCallBack?) = callBack.run {
        provideText(getJokeUi())
        provideIconRes(getIconResId())
    }

}
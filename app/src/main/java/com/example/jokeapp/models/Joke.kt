package com.example.jokeapp.models

import androidx.annotation.DrawableRes

abstract class Joke(private val text: String, private val punchline: String) {

    protected fun getJokeUi() = "$text\n$punchline"

    @DrawableRes
    protected abstract fun getIconResId() : Int

    fun map(callBack: DataCallBack) = callBack.run {
        provideText(getJokeUi())
        provideIconRes(getIconResId())
    }

}
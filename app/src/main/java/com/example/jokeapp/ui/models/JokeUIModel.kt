package com.example.jokeapp.ui.models

import com.example.jokeapp.ui.state.State
import org.bson.AbstractBsonReader

abstract class JokeUIModel(private val text: String, private val punchline: String) {

    protected open fun text() = "$text\n$punchline"
    @DrawableRes
    protected abstract fun getIconResId(): Int

    open fun show(communication: Communication) =
        communication.showState(
            State.Initial(text(),getIconResId())
    )
}
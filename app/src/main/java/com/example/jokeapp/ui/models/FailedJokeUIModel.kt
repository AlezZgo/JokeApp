package com.example.jokeapp.ui.models

import com.example.jokeapp.R
import com.example.jokeapp.ui.state.State

class FailedJokeUIModel(private val text: String) : JokeUIModel(text, "") {

    override fun text(): String = text
    override fun getIconResId() = R.drawable.ic_baseline_favorite_border_24
    override fun show(communication: Communication) =
        communication.showState(
            State.Failed(text()),
            getIconResId()
        )
}
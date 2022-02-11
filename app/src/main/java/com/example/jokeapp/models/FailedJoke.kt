package com.example.jokeapp.models

import com.example.jokeapp.domain.Joke

class FailedJoke(text: String) : Joke(text,"") {
    override fun getIconResId(): Int = 0
}
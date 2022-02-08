package com.example.jokeapp.models

class FailedJoke(text: String) : Joke(text,"") {
    override fun getIconResId(): Int = 0
}
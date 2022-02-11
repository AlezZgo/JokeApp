package com.example.jokeapp.models

import com.example.jokeapp.R
import com.example.jokeapp.domain.Joke

class FavouriteJoke(text: String, punchline: String)  : Joke(text,punchline) {
    override fun getIconResId(): Int = R.drawable.ic_baseline_favorite_24
}
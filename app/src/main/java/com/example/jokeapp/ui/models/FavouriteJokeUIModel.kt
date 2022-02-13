package com.example.jokeapp.ui.models

import com.example.jokeapp.R

class FavouriteJokeUIModel(text: String, punchline: String) : JokeUIModel(text, punchline) {
    override fun getIconResId() = R.drawable.ic_baseline_favorite_border_24
}
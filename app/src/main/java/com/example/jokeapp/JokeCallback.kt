package com.example.jokeapp

import com.example.jokeapp.models.Joke

interface JokeCallback {

    fun provide(joke: Joke)


}

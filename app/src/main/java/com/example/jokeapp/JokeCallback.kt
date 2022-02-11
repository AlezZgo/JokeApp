package com.example.jokeapp

import com.example.jokeapp.domain.Joke

interface JokeCallback {

    fun provide(joke: Joke)


}

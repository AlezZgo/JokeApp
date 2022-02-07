package com.example.jokeapp.models

import com.example.jokeapp.Errors.JokeFailure

interface Model {

    fun getJoke()

    fun init(callBack: ResultCallBack)

    fun clear()

}

interface ResultCallBack {

    fun provideSuccess(data: Joke)

    fun provideError(error: JokeFailure)
}




package com.example.jokeapp.models

import androidx.annotation.DrawableRes
import com.example.jokeapp.Errors.JokeFailure

interface Model {

    fun getJoke()

    fun init(callBack: ResultCallBack)

    fun clear()

}

interface ResultCallBack {

    fun provide(joke: Joke)

}

interface DataCallBack{

    fun provideText(text: String)

    fun provideIconRes(@DrawableRes id:Int)

}




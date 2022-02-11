package com.example.jokeapp.models

import androidx.annotation.DrawableRes
import com.example.jokeapp.JokeCallback

interface Model {

    fun getJoke()

    fun init(callBack: JokeCallback)

    fun clear()

    fun changeJokeStatus(jokeCallBack: JokeCallback)

}

interface ResultCallBack {

    fun provide(joke: Joke)

}

interface DataCallBack{

    fun provideText(text: String)

    fun provideIconRes(@DrawableRes id:Int)

}




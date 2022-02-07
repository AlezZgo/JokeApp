package com.example.jokeapp

interface Model<S, E> {

    fun getJoke()

    fun init(callBack: ResultCallBack<S, E>)

    fun clear()

}




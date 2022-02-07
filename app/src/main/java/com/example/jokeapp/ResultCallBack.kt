package com.example.jokeapp

interface ResultCallBack<S, E> {

    fun provideSuccess(data: S)

    fun provideError(error: E)
}
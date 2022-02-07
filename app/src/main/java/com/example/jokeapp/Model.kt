package com.example.jokeapp

import android.service.carrier.CarrierMessagingService

interface Model<S,E> {

    fun getJoke()

    fun init(callBack: ResultCallBack<S,E>)

    fun clear()
}

interface ResultCallBack<S,E>{

    fun provideSuccess(data: S)

    fun provideError(error: E)
}
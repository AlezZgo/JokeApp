package com.example.jokeapp

import com.example.jokeapp.models.DataCallBack
import com.example.jokeapp.domain.Joke
import com.example.jokeapp.models.Model


class ViewModel(private val model: Model) {

    private var dataCallback: DataCallBack? = null

    private val jokeCallBack = object : JokeCallback{
        override fun provide(joke: Joke){
            dataCallback.let{
                joke.map(it)
            }
        }
    }

    fun init(callBack: DataCallBack){
        dataCallback = callBack

        model.init(jokeCallBack)
    }

    fun changeJokeStatus(jokeCallback: JokeCallback){
        cachedJokeServerModel?.change(cacheDataSource)?.let{
            jokeCallback.provide(it)
        }
    }

    fun getJoke(){
        model.getJoke()
    }

    fun clear(){
        dataCallback = null
        model.clear()
    }

    fun chooseFavourites(favourites: Boolean) {

    }

}

interface TextCallBack{
    fun provideText(text: String)
}
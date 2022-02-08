package com.example.jokeapp

import com.example.jokeapp.Errors.JokeFailure
import com.example.jokeapp.models.DataCallBack
import com.example.jokeapp.models.Joke
import com.example.jokeapp.models.Model
import com.example.jokeapp.models.ResultCallBack


class ViewModel(private val model: Model) {

    private var dataCallback: DataCallBack? = null

    fun init(callBack: DataCallBack){
        dataCallback = callBack

        model.init(object : ResultCallBack {
            override fun provide(joke: Joke) {
                dataCallback?.let {
                    joke.map(it)
                }
            }

        })
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
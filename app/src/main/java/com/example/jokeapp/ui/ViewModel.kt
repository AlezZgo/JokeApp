package com.example.jokeapp

import com.example.jokeapp.Errors.JokeFailure
import com.example.jokeapp.models.Joke
import com.example.jokeapp.models.Model
import com.example.jokeapp.models.ResultCallBack


class ViewModel(private val model: Model) {

    private var callback: TextCallBack? = null

    fun init(callBack: TextCallBack){
        this.callback = callBack

        model.init(object : ResultCallBack {
            override fun provideSuccess(data: Joke) {
                callBack.provideText(data.getJokeUi())
            }

            override fun provideError(error: JokeFailure) {
                callBack.provideText(error.getMessage())
            }
        })
    }

    fun getJoke(){
        model.getJoke()
    }

    fun clear(){
        callback = null
        model.clear()
    }

}

interface TextCallBack{
    fun provideText(text: String)
}
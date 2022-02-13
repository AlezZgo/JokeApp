package com.example.jokeapp.ui

import com.example.jokeapp.JokeCallback
import com.example.jokeapp.ViewModel
import com.example.jokeapp.domain.Joke
import com.example.jokeapp.domain.JokeInteractor
import com.example.jokeapp.models.DataCallBack
import com.example.jokeapp.ui.models.BaseCommunication
import com.example.jokeapp.ui.models.Communication
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher

class BaseViewModel(
    private val interactor: JokeInteractor,
    private val communication: Communication,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel {


    private var dataCallback: DataCallBack? = null

    private val jokeCallBack = object : JokeCallback {
        override fun provide(joke: Joke) {
            dataCallback.let {
                joke.map(it)
            }
        }
    }

    fun init(callBack: DataCallBack) {
        dataCallback = callBack

        model.init(jokeCallBack)
    }

    fun changeJokeStatus(jokeCallback: JokeCallback) {
        cachedJokeServerModel?.change(cacheDataSource)?.let {
            jokeCallback.provide(it)
        }
    }

    fun getJoke() {
        model.getJoke()
    }

    fun clear() {
        dataCallback = null
        model.clear()
    }

    fun chooseFavourites(favourites: Boolean) {

    }

}
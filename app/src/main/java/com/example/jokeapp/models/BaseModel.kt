package com.example.jokeapp.models

import com.example.jokeapp.Errors.NoConnection
import com.example.jokeapp.Errors.ServiceUnavailable
import com.example.jokeapp.JokeCallback
import com.example.jokeapp.data.*
import com.example.jokeapp.data.cache.CacheDataSource
import com.example.jokeapp.data.cloud.CloudDataSource
import com.example.jokeapp.data.cloud.ErrorType
import com.example.jokeapp.data.cloud.JokeCloudCallback
import com.example.jokeapp.data.cloud.JokeServerModel
import com.example.jokeapp.resources.ResourceManager

class BaseModel(
    private val cacheDataSource: CacheDataSource,
    private val cloudDataSource: CloudDataSource,
    private val resourceManager: ResourceManager
) : Model {

    private val noConnection by lazy { NoConnection(resourceManager) }
    private val serviceUnavailable by lazy { ServiceUnavailable(resourceManager) }

    private var jokeCallback: JokeCallback? = null
    private var cachedJokeServerModel: JokeServerModel? = null

    override fun getJoke(){
        cloudDataSource.getJoke(object : JokeCloudCallback {
            override fun provide(joke: JokeServerModel) {
                cachedJokeServerModel = joke
                jokeCallback?.provide(joke.toBaseJoke())
            }

            override fun fail(error: ErrorType) {
                cachedJokeServerModel = null
                val failure = if(error == ErrorType.NO_CONNECTION) noConnection else serviceUnavailable
                jokeCallback?.provide(FailedJoke(failure.getMessage()))
            }

        })
    }

    override fun init(callBack: JokeCallback) {
        this.jokeCallback = callBack
    }

    override fun clear() {
        jokeCallback = null
    }


}
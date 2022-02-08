package com.example.jokeapp.models

import com.example.jokeapp.Errors.NoConnection
import com.example.jokeapp.Errors.ServiceUnavailable
import com.example.jokeapp.resources.ResourceManager

class TestModel(resManager : ResourceManager) : Model {

    private var callBack: ResultCallBack? = null

    private var count = 0

    private val noConnection = NoConnection(resManager)

    private val serviceUnavailable = ServiceUnavailable(resManager)

    override fun getJoke() = Thread{
        Thread.sleep(1000)

        when (count) {
            0 -> callBack?.provide(BaseJoke("testText","testPunchLine"))
            1 -> callBack?.provide(FavouriteJoke("favouriteTestText","favouriteTestPunchLine"))
            2 -> callBack?.provide(FailedJoke(serviceUnavailable.getMessage()))
        }
        count++
        if (count == 3) count = 0
    }.start()

    override fun init(callBack: ResultCallBack) {
        this.callBack = callBack
    }

    override fun clear() {
        callBack = null
    }

}

package com.example.jokeapp.models

import com.example.jokeapp.ErrorType
import com.example.jokeapp.Errors.NoConnection
import com.example.jokeapp.Errors.ServiceUnavailable
import com.example.jokeapp.JokeService
import com.example.jokeapp.ServiceCallback
import com.example.jokeapp.data.JokeDto
import com.example.jokeapp.data.JokeMapper
import com.example.jokeapp.resources.ResourceManager

class BaseModel(
    private val service: JokeService,
    private val resourceManager: ResourceManager
) : Model {

    private var callBack: ResultCallBack? = null
    private val noConnection by lazy{ NoConnection(resourceManager)}
    private val serviceUnavailable by lazy{ ServiceUnavailable(resourceManager)}

    override fun getJoke() {
        service.getJoke(object : ServiceCallback{
            override fun returnSuccess(dto: JokeDto) {
                callBack?.provideSuccess(JokeMapper.mapDtoToEntity(dto))
            }

            override fun returnError(type: ErrorType) {
                when(type){
                    ErrorType.NO_CONNECTION -> callBack?.provideError(noConnection)
                    ErrorType.OTHER -> callBack?.provideError(serviceUnavailable)
                }
            }

        })
    }

    override fun init(callBack: ResultCallBack) {
        this.callBack = callBack
    }

    override fun clear() {
        callBack = null
    }
}
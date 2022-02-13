package com.example.jokeapp.data.cloud

import com.example.jokeapp.data.JokeDataModel
import com.example.jokeapp.domain.exceptions.NoConnectionException
import com.example.jokeapp.domain.exceptions.ServiceUnavailableException
import java.net.UnknownHostException

class BaseCloudDataSource(private val service: JokeService) : CloudDataSource {
    override suspend fun getJoke(): JokeDataModel {
        try {
            return service.getJoke().execute().body()!!.to()
        } catch (e: Exception) {
            if (e is UnknownHostException) {
                throw NoConnectionException()
            } else {
                throw ServiceUnavailableException()
            }
        }
    }


}
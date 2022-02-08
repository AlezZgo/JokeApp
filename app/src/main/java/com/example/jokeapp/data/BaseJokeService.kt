package com.example.jokeapp.data

import com.example.jokeapp.ErrorType
import com.example.jokeapp.JokeService
import com.example.jokeapp.ServiceCallback
import com.google.gson.Gson
import java.io.BufferedInputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.UnknownHostException

class BaseJokeService(private val gson: Gson) : JokeService {
    override fun getJoke(callBack: ServiceCallback) = Thread{
        var connection: HttpURLConnection? = null
        try{
            val url = URL(JOKE_URL)
            connection = url.openConnection() as HttpURLConnection
            InputStreamReader(BufferedInputStream(connection.inputStream)).use {
                val line : String = it.readText()
                val dto = gson.fromJson(line,JokeDto::class.java)
                callBack.returnSuccess(dto)
            }
        }catch (e: Exception){
            if (e is UnknownHostException){
                callBack.returnError(ErrorType.NO_CONNECTION)
            }else
                callBack.returnError(ErrorType.OTHER)
        }finally {
            connection?.disconnect()
        }

    }.start()

    private companion object{
        const val JOKE_URL = "https://v2.jokeapi.dev/joke/Any?format=json"
    }
}
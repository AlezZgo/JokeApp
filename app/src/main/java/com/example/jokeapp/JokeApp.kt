package com.example.jokeapp

import android.app.Application
import com.example.jokeapp.models.BaseModel
import com.example.jokeapp.resources.BaseResourceManager
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class JokeApp : Application() {

    lateinit var viewModel: ViewModel

    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.google.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun onCreate() {
        super.onCreate()
        viewModel = ViewModel(BaseModel(retrofit.create(JokeService::class.java),BaseResourceManager(this)))
    }
}
package com.example.jokeapp

import android.app.Application
import com.example.jokeapp.models.TestModel
import com.example.jokeapp.resources.BaseResourceManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeApp : Application() {

    lateinit var viewModel: ViewModel

    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.google.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun onCreate() {
        super.onCreate()
        viewModel = ViewModel(TestModel(BaseResourceManager(this)))
    }
}
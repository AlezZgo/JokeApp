package com.example.jokeapp

import android.app.Application
import com.example.jokeapp.data.BaseJokeService
import com.example.jokeapp.models.BaseModel
import com.example.jokeapp.models.TestModel
import com.example.jokeapp.resources.BaseResourceManager
import com.google.gson.Gson

class JokeApp : Application() {

    lateinit var viewModel: ViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = ViewModel(BaseModel(BaseJokeService(Gson()),BaseResourceManager(this)))
    }
}
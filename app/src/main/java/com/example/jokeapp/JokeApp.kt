package com.example.jokeapp

import android.app.Application
import com.example.jokeapp.models.TestModel
import com.example.jokeapp.resources.BaseResourceManager

class JokeApp : Application() {

    lateinit var viewModel: ViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = ViewModel(TestModel(BaseResourceManager(this)))
    }
}
package com.example.jokeapp

import com.example.jokeapp.models.Model


interface ViewModel(private val model: Model) {

}

interface TextCallBack {
    fun provideText(text: String)
}
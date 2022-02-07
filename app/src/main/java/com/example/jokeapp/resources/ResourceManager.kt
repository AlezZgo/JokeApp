package com.example.jokeapp.resources

import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes stringResId: Int) : String
}


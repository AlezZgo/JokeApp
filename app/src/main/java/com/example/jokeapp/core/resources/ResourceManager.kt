package com.example.jokeapp.core.resources

import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes stringResId: Int) : String
}


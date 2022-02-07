package com.example.jokeapp.resources

import android.content.Context

class BaseResourceManager(private val context: Context) : ResourceManager {
    override fun getString(stringResId: Int): String {
        return context.getString(stringResId)
    }
}
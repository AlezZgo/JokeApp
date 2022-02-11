package com.example.jokeapp.core.resources

import android.content.Context

class BaseResourceManager(private val context: Context) : ResourceManager {
    override fun getString(stringResId: Int): String {
        return context.getString(stringResId)
    }
}
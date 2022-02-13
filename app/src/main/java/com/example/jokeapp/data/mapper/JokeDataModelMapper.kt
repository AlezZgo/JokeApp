package com.example.jokeapp.data.mapper

interface JokeDataModelMapper<T> {
    fun map(id: Int, text: String, punchLine: String, cached: Boolean): T
}

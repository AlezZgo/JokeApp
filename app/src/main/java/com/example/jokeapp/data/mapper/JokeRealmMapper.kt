package com.example.jokeapp.data.mapper

import com.example.jokeapp.data.cache.JokeRealmModel
import com.example.jokeapp.data.cloud.JokeServerModel

class JokeRealmMapper: JokeDataModelMapper<JokeRealmModel> {
    override fun map(id: Int, text: String, punchLine: String, cached: Boolean): JokeRealmModel =
        JokeRealmModel().also{
            it.id = id
            it.text = text
            it.punchline = punchLine
        }
}


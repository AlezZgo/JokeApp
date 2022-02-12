package com.example.jokeapp.data.cache

import com.example.jokeapp.data.JokeDataModel
import com.example.jokeapp.data.cloud.JokeServerModel
import com.example.jokeapp.data.mapper.JokeDataModelMapper
import com.example.jokeapp.domain.Joke

class BaseCachedDataSource(
    private val realmProvider: RealmProvider,
    private val mapper: JokeDataModelMapper<JokeRealmModel>,
) : CacheDataSource {
    override suspend fun getJoke(): JokeDataModel {

    }

    override suspend fun addOrRemove(id: Int, joke: JokeDataModel): JokeDataModel {
        TODO("Not yet implemented")
    }


}
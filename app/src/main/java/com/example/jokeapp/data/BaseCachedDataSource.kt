package com.example.jokeapp.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BaseCachedDataSource(
    private val realmProvider: RealmProvider,
    private val mapper: JokeDataModelMapper<JokeRealmModel>,
) : CacheDataSource {
    override suspend fun getJoke(): JokeDataModel {
        realmProvider.provide().use {
            val jokes = it.where(JokeRealmModel::class.java).findAll()
            if (jokes.isEmpty())
                throw NoCachedJokesException()
            else
                return jokes.random().to()
        }
    }

    override suspend fun addOrRemove(id: Int, joke: JokeDataModel): JokeDataModel =
        withContext(Dispatchers.IO) {
            realmProvider.provide().use {

                val jokeRealm = it.where(JokeRealmModel::class.java).equalTo(, id).findFirst()

                return if (jokeRealm == null) {
                    it.executeTransaction { transaction ->

                        val newjoke = joke.map(mapper)
                        transaction.insert(newJoke)

                        joke.changeCached(true)


                    }
                }
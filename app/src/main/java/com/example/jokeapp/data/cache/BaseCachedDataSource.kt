package com.example.jokeapp.data.cache

import com.example.jokeapp.data.JokeDataModel
import com.example.jokeapp.data.cloud.JokeServerModel
import com.example.jokeapp.data.mapper.JokeDataModelMapper
import com.example.jokeapp.domain.Joke
import com.example.jokeapp.domain.exceptions.NoCachedJokesException
import io.realm.kotlin.where
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BaseCachedDataSource(
    private val realmProvider: RealmProvider,
    private val mapper: JokeDataModelMapper<JokeRealmModel>,
) : CacheDataSource {
    override suspend fun getJoke(): JokeDataModel {
        realmProvider.provide().use{
            val jokes = it.where(JokeRealmModel::class.java).findAll()
            if(jokes.isEmpty())
                throw NoCachedJokesException()
            else
                return jokes.random().to()
        }
    }

    override suspend fun addOrRemove(id: Int, joke: JokeDataModel): JokeDataModel =
        withContext(Dispatchers.IO){
            realmProvider.provide().use {
                val jokeRealm =
                    it.where(JokeRealmModel::class.java).equalTo("id",id).findFirst()
                return@withContext if(jokeRealm==null){
                    it.executeTransaction{transaction->
                        val newJoke = joke.map(mapper)
                        transaction.insert(newJoke)
                    }
                    joke.changeCached(true)
                }else{
                    it.executeTransaction{
                        jokeRealm.deleteFromRealm()
                    }
                    joke.changeCached(false)
                }
            }
        }



}
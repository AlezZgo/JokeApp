package com.example.jokeapp

import android.app.Application
import com.example.jokeapp.core.resources.BaseResourceManager
import com.example.jokeapp.data.cache.BaseCachedDataSource
import com.example.jokeapp.data.cache.BaseRealmProvider
import com.example.jokeapp.data.cache.cachedJoke.BaseCachedJoke
import com.example.jokeapp.data.cloud.BaseCloudDataSource
import com.example.jokeapp.data.cloud.JokeService
import com.example.jokeapp.data.mapper.JokeRealmMapper
import com.example.jokeapp.data.mapper.JokeSuccessMapper
import com.example.jokeapp.data.repository.BaseJokeRepository
import com.example.jokeapp.domain.BaseJokeInteractor
import com.example.jokeapp.domain.JokeFailureFactory
import com.example.jokeapp.ui.BaseViewModel
import com.example.jokeapp.ui.models.BaseCommunication
import io.realm.Realm
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeApp : Application() {

    lateinit var viewModel: BaseViewModel

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val cacheDataSource = BaseCachedDataSource(BaseRealmProvider(), JokeRealmMapper())
        val resourceManager = BaseResourceManager(this)
        val cloudDataSource = BaseCloudDataSource(retrofit.create(JokeService::class.java))
        val repository = BaseJokeRepository(cacheDataSource, cloudDataSource, BaseCachedJoke())
        val interactor =
            BaseJokeInteractor(repository, JokeFailureFactory(resourceManager), JokeSuccessMapper())


        viewModel = BaseViewModel(interactor, BaseCommunication())
    }


}
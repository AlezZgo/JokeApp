package com.example.jokeapp.data

import com.example.jokeapp.models.Joke

class TestDataSource : CacheDataSource {

    private val map = HashMap<Int,JokeServerModel>()

    override fun addOrRemove(id: Int, jokeServerModel: JokeServerModel): Joke {
        return if(map.containsKey(id)){
            val joke = map[id]!!.toBaseJoke()
            map.remove(id)
            joke
        }else{
            map[id] = jokeServerModel
            jokeServerModel.toFavouriteJoke()
        }
    }
}
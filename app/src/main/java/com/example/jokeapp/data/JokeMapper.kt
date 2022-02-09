package com.example.jokeapp.data

import com.example.jokeapp.models.BaseJoke

object JokeMapper {

    fun mapDtoToEntity(serverModel: JokeServerModel): BaseJoke {

        return if(serverModel.joke==null){
            BaseJoke(serverModel.setup ?: throw RuntimeException("serverModel setup param is null"),
                serverModel.delivery ?: throw RuntimeException("serverModel delivery param is null "))
        }else{
            BaseJoke(serverModel.joke,"")
        }


    }


}


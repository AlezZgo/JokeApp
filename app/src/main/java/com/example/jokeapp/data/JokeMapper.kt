package com.example.jokeapp.data

import com.example.jokeapp.models.BaseJoke
import com.example.jokeapp.models.Joke

object JokeMapper {

    fun mapDtoToEntity(dto: JokeDto): BaseJoke {

        return if(dto.joke==null){
            BaseJoke(dto.setup ?: throw RuntimeException("dto setup param is null"),
                dto.delivery ?: throw RuntimeException("dto delivery param is null "))
        }else{
            BaseJoke(dto.joke,"")
        }


    }


}


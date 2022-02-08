package com.example.jokeapp.data

import com.example.jokeapp.models.Joke

object JokeMapper {

    fun mapDtoToEntity(dto: JokeDto): Joke {

        return if(dto.joke==null){
            Joke(dto.setup ?: throw RuntimeException("dto setup param is null"),
                dto.delivery ?: throw RuntimeException("dto delivery param is null "))
        }else{
            Joke(dto.joke,"")
        }


    }


}


package com.example.jokeapp.domain

import com.example.jokeapp.core.Mapper
import com.example.jokeapp.domain.Errors.JokeFailure
import com.example.jokeapp.ui.models.BaseJokeUIModel
import com.example.jokeapp.ui.models.FailedJokeUIModel
import com.example.jokeapp.ui.models.FavouriteJokeUIModel
import com.example.jokeapp.ui.models.JokeUIModel


sealed class Joke : Mapper<JokeUIModel> {

    class Success(
        private val text: String,
        private val punchline: String,
        private val favourite: Boolean
    ) : Joke(){
        override fun to(): JokeUIModel {
            return if(favourite){
                FavouriteJokeUIModel(text,punchline)
            }else{
                BaseJokeUIModel(text,punchline)
            }
        }
    }

    class Failed(private val failure: JokeFailure) : Joke(){
        override fun to(): JokeUIModel {
            return FailedJokeUIModel(failure.getMessage())
        }

    }


}
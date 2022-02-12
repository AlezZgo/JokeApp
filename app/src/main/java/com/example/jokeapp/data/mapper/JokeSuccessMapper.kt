package com.example.jokeapp.data.mapper

import com.example.jokeapp.domain.Joke

class JokeSuccessMapper : JokeDataModelMapper<Joke.Success> {
    override fun map(id: Int, text: String, punchLine: String, cached: Boolean) = Joke.Success(
        text,
        punchLine,
        cached
    )

}
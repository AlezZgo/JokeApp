package com.example.jokeapp.data.cache

import com.example.jokeapp.core.Mapper
import com.example.jokeapp.data.JokeDataModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class JokeRealmModel : RealmObject(), Mapper<JokeDataModel> {
    @PrimaryKey
    var id: Int = -1
    var text: String = ""
    var punchline: String = ""

    override fun to(): JokeDataModel = JokeDataModel(id, text, punchline)
}
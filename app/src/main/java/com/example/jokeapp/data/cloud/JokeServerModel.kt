package com.example.jokeapp.data.cloud

import com.example.jokeapp.core.Mapper
import com.example.jokeapp.data.JokeDataModel
import com.google.gson.annotations.SerializedName

data class JokeServerModel(
    @SerializedName("error") val error: Boolean,
    @SerializedName("category") val category: String,
    @SerializedName("type") val type: String,
    @SerializedName("joke") val joke: String?,
    @SerializedName("setup") val text: String?,
    @SerializedName("delivery") val punchline: String?,
    @SerializedName("flags") val flags: Flags,
    @SerializedName("id") val id: Int,
    @SerializedName("safe") val safe: Boolean,
    @SerializedName("lang") val lang: String,
) : Mapper<JokeDataModel> {

    override fun to() = JokeDataModel(id, text ?: "another json", punchline ?: "another json")

}
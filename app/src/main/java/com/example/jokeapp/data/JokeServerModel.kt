package com.example.jokeapp.data

import com.google.gson.annotations.SerializedName

data class JokeServerModel (
    @SerializedName("error") val error : Boolean,
    @SerializedName("category") val category : String,
    @SerializedName("type") val type : String,
    @SerializedName("joke") val joke : String?,
    @SerializedName("setup") val setup : String?,
    @SerializedName("delivery") val delivery : String?,
    @SerializedName("flags") val flags : Flags,
    @SerializedName("id") val id : Int,
    @SerializedName("safe") val safe : Boolean,
    @SerializedName("lang") val lang : String
){
    fun change(cacheDataSource: CacheDataSource) = cacheDataSource.addOrRemove(id,this)
}
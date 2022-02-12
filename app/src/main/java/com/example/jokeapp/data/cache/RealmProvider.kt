package com.example.jokeapp.data.cache

interface RealmProvider {
    fun provide() : Realm
}
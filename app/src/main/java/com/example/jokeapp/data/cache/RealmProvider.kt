package com.example.jokeapp.data.cache

import io.realm.Realm

interface RealmProvider {
    fun provide(): Realm
}
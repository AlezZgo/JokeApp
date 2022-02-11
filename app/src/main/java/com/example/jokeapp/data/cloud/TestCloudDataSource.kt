package com.example.jokeapp.data.cloud

class TestCloudDataSource: CloudDataSource {
    override fun getJoke(callback: JokeCloudCallback) {
        callback.provide(JokeServerModel(0,"testType","testText","TestPunchline"))
    }
}
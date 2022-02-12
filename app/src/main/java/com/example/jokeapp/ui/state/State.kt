package com.example.jokeapp.ui.state

sealed interface State{

    class Initial : Info()

    object Progress

    class Failed : Info()

}
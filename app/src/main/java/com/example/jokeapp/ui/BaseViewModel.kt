package com.example.jokeapp.ui

import android.icu.lang.UCharacter.DecompositionType.INITIAL
import com.example.jokeapp.ViewModel
import com.example.jokeapp.domain.JokeInteractor
import com.example.jokeapp.ui.models.Communication
import com.example.jokeapp.ui.state.State
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import java.util.*

class BaseViewModel(
    private val interactor: JokeInteractor,
    private val communication: Communication,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main,
) : ViewModel {

    fun getJoke() {
        communication.showState(State.Progress)
        interactor.getJoke().to().show(communication)
    }

    fun changeJokeStatus() = viewModelScope.launch(dispatcher) {
        if (communication.isState(INITIAL))
            interactor.changeFavourites().to().show(communication)
    }

    fun chooseFavourites(favourites: Boolean) =
        interactor.getFavouriteJokes(favourites)

    fun observe(owner: LifecycleOwner, observer: Observer<State>) =
        communication.observe(owner, observer)

}
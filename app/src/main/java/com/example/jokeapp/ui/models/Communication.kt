package com.example.jokeapp.ui.models

import androidx.lifecycle.LifecycleOwner
import com.example.jokeapp.ui.state.State
import java.util.*

interface Communication {

    fun showState(state: State)
    fun observe(owner: LifecycleOwner, observer: Observer<State>)
    fun isState(typo: Int): Boolean
}


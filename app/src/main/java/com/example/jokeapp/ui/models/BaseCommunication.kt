package com.example.jokeapp.ui.models

import androidx.lifecycle.MutableLiveData
import com.example.jokeapp.ui.state.State
import java.util.*


class BaseCommunication : Communication {

    private val liveData = MutableLiveData<State>()


    override fun isState(typo: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun showState(state: State) {
        TODO("Not yet implemented")
    }

    override fun observe(owner: LifecyleOwner, observer: Observer<State>) =
        livedata


}
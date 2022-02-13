package com.example.jokeapp.ui.models

import androidx.lifecycle.MutableLiveData
import com.example.jokeapp.ui.state.State
import java.util.*

class BaseCommunication : Communication {

    private val liveData = MutableLiveData<State>()

    override fun isState(typo: Int): Boolean = liveData.value?.isType(type) ?: false

    override fun showState(state: State) {
        liveData.value = state
    }

    override fun observe(owner: LifecyсleOwner, observer: Observer<State>) =
        livedata.observe(owner, observer)


}
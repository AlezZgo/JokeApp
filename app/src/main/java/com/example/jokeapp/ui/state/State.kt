package com.example.jokeapp.ui.state

import com.example.jokeapp.ui.showInterface.EnableView
import com.example.jokeapp.ui.showInterface.ShowImage
import com.example.jokeapp.ui.showInterface.ShowText
import com.example.jokeapp.ui.showInterface.ShowView

sealed class State {

    protected abstract val type: Int

    companion object {
        const val INITIAL = 0
        const val PROGRESS = 1
        const val FAILED = 2
    }

    fun isType(type: Int): Boolean = this.type == type


    fun show(
        progress: ShowView,
        button: EnableView,
        textView: ShowText,
        imageButton: ShowImage,
    ) {
        show(progress, button)
        show(textView, imageButton)
    }

    protected open fun show(progress: ShowView, button: EnableView) {}
    protected open fun show(textView: ShowText, imageButton: ShowImage) {}

    object Progress : State() {
        override val type = PROGRESS

        override fun show(progress: ShowView, button: EnableView) {
            progress.show(true)
            button.enable(false)
        }
    }

}



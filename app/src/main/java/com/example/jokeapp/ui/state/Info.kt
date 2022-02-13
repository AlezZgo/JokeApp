package com.example.jokeapp.ui.state

import com.example.jokeapp.ui.models.DrawableRes
import com.example.jokeapp.ui.showInterface.EnableView
import com.example.jokeapp.ui.showInterface.ShowImage
import com.example.jokeapp.ui.showInterface.ShowText
import com.example.jokeapp.ui.showInterface.ShowView

abstract class Info(private val text: String, @DrawableRes private val id: Int) : State() {
    override fun show(progress: ShowView, button: EnableView) {
        progress.show(false)
        button.enable(true)
    }

    override fun show(textView: ShowText, imageButton: ShowImage) {
        textView.show(text)
        imageButton.show(id)
    }

}

class Initial(text: String, @DrawableRes private val id: Int) : Info(text, id) {
    override val type = INITIAL
}

class Failed(text: String, @DrawableRes private val id: Int) : Info(text, id) {
    override val type = FAILED
}
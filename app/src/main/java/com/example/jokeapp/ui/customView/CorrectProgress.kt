package com.example.jokeapp.ui.customView

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import com.example.jokeapp.ui.showInterface.ShowView

class CorrectProgress : ProgressBar, ShowView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    override fun show(arg: Int) {
        visibility = if (arg) View.VISIBLE else View.INVISIBLE
    }
}
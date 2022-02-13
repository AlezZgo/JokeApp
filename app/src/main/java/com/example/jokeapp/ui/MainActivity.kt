package com.example.jokeapp.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.jokeapp.JokeApp
import com.example.jokeapp.R
import com.example.jokeapp.ViewModel
import com.example.jokeapp.ui.customView.CorrectButton
import com.example.jokeapp.ui.customView.CorrectImageButton
import com.example.jokeapp.ui.customView.CorrectProgress
import com.example.jokeapp.ui.customView.CorrectTextView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = (application as JokeApp).viewModel
        val button = findViewById<CorrectButton>(R.id.btn)
        val progressBar = findViewById<CorrectProgress>(R.id.pb)
        val textView = findViewById<CorrectTextView>(R.id.tv)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val changeButton = findViewById<CorrectImageButton>(R.id.changeButton)
        progressBar.visibility = View.INVISIBLE

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            viewModel.chooseFavourites(isChecked)
        }

        changeButton.setOnClickListener {
            viewModel.changeJokeStatus()
        }

        button.setOnClickListener {
            viewModel.getJoke()
        }

        viewModel.observe(this) { state ->
            state.show(progressBar, button, textView, changeButton)
        }


    }

}


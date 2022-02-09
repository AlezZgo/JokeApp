package com.example.jokeapp.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.jokeapp.JokeApp
import com.example.jokeapp.R
import com.example.jokeapp.ViewModel
import com.example.jokeapp.models.DataCallBack

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = (application as JokeApp).viewModel
        val button = findViewById<Button>(R.id.btn)
        val progressBar = findViewById<View>(R.id.pb)
        val textView = findViewById<TextView>(R.id.tv)
        val changeButton = findViewById<ImageButton>(R.id.changeButton)
        progressBar.visibility = View.INVISIBLE

        button.setOnClickListener {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
            viewModel.getJoke()
        }

        changeButton.setOnClickListener {
            viewModel.changeJokeStatus()
        }

        viewModel.init(object : DataCallBack {
            override fun provideText(text: String) = runOnUiThread{
                button.isEnabled = true
                progressBar.visibility = View.INVISIBLE
                textView.text = text
            }

            override fun provideIconRes(id: Int) {
                runOnUiThread {
                    iconView.setImageResource(id)
                }
            }

        })

        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        checkBox.setOnCheckedChangeListener{ _, isChecked ->
            viewModel.chooseFavourites(isChecked)
        }



    }

    override fun onDestroy() {
        viewModel.clear()
        super.onDestroy()
    }
}


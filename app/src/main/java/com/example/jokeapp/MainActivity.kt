package com.example.jokeapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = (application as JokeApp).viewModel
        val button = findViewById<Button>(R.id.btn)
        val progressBar = findViewById<View>(R.id.pb)
        val textView = findViewById<TextView>(R.id.tv)
        progressBar.visibility = View.INVISIBLE

        button.setOnClickListener {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
            viewModel.getJoke()
        }

        viewModel.init(object : TextCallBack {
            override fun provideText(text: String) {
                button.isEnabled = true
                progressBar.visibility = View.INVISIBLE
                textView.text = text
            }

        })

    }

    override fun onDestroy() {
        viewModel.clear()
        super.onDestroy()
    }
}


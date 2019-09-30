package com.example.tesuto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.makeNetworkRequest()

        viewModel.data.observe(this, Observer { text ->
            text?.let {
                hello.text = text
            }
        })*/

        doAsync {
            val document = Jsoup.connect("https://tonyrusso.space").get()

            uiThread {
                hello.text = document.select("h1").first().text()
            }

        }
    }
}

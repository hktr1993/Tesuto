package com.example.tesuto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class MainViewModel : ViewModel() {

    val data = MutableLiveData<String>()

    // Make a network request without blocking the UI thread
    fun makeNetworkRequest() {
        // launch a coroutine in viewModelScope
        viewModelScope.launch(Dispatchers.IO) {
            // slowFetch()
            val document = Jsoup.connect("https://tonyrusso.space").get()

            data.postValue(document.select("h1").first().text())
        }
    }
}
package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel : ViewModel() {
    private val _winner = MutableLiveData<String>()
    val winner: LiveData<String> = _winner

    fun onLoad(text: String) {
        _winner.postValue(text)
    }
}
package com.yourssu.unscramble.presentation.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StartViewModel : ViewModel() {
    val title = MutableLiveData("UNSCRAMBLE")
    val btn = MutableLiveData("START")
}

package com.yourssu.unscramble.presentation.end

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class EndViewModel : ViewModel() {
    private val _result: MutableStateFlow<String> = MutableStateFlow("Time out!")
    val result: MutableStateFlow<String> = _result

    private val _score: MutableStateFlow<Int> = MutableStateFlow(100)
    val score: MutableStateFlow<Int> = _score
}
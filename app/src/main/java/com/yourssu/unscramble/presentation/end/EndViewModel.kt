package com.yourssu.unscramble.presentation.end

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class EndViewModel : ViewModel() {
    private val _result: MutableStateFlow<String> = MutableStateFlow("Time out!")
    val result: StateFlow<String> = _result

    private val _score: MutableStateFlow<Int> = MutableStateFlow(0)
    val score: StateFlow<Int> = _score
}
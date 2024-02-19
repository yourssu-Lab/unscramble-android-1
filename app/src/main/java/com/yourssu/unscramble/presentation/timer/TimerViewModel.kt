package com.yourssu.unscramble.presentation.timer

import android.text.Editable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TimerViewModel : ViewModel() {

    private val _timerMinute: MutableStateFlow<Int> = MutableStateFlow(0)
    val timerMinute: StateFlow<Int> = _timerMinute

    private val _timerSecond: MutableStateFlow<Int> = MutableStateFlow(0)
    val timerSecond: StateFlow<Int> = _timerSecond

    private val _timerButtonText: MutableStateFlow<String> = MutableStateFlow("START")
    val timerButtonText: StateFlow<String> = _timerButtonText

    fun updateMinute(s: Editable) {
        _timerMinute.value = s.toString().toInt()
    }

    fun updateSecond(s: Editable) {
        _timerSecond.value = s.toString().toInt()
    }

    fun getTotalTime(): Int {
        return timerMinute.value * 60 + timerSecond.value
    }
}

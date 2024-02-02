package com.yourssu.unscramble.presentation.timer

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class TimerViewModel : ViewModel() {
    private val _timerHour: MutableStateFlow<Int> = MutableStateFlow(0)
    val timerHour: MutableStateFlow<Int> = _timerHour

    private val _timerMinute: MutableStateFlow<Int> = MutableStateFlow(0)
    val timerMinute: MutableStateFlow<Int> = _timerMinute
}

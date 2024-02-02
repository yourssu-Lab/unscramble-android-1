package com.yourssu.unscramble.presentation.play

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class PlayViewModel : ViewModel() {
    private val _questionWord: MutableStateFlow<String> = MutableStateFlow("")
    val questionWord: MutableStateFlow<String> = _questionWord

    private val _currentScore: MutableStateFlow<Int> = MutableStateFlow(0)
    val currentScore: MutableStateFlow<Int> = _currentScore

    private val _solvedProblem: MutableStateFlow<Int> = MutableStateFlow(0)
    val solvedProblem: MutableStateFlow<Int> = _solvedProblem

    private val _timerHour: MutableStateFlow<Int> = MutableStateFlow(0)
    val timerHour: MutableStateFlow<Int> = _timerHour

    private val _timerMinute: MutableStateFlow<Int> = MutableStateFlow(0)
    val timerMinute: MutableStateFlow<Int> = _timerMinute
}

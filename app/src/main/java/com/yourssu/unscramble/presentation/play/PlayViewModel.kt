package com.yourssu.unscramble.presentation.play

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PlayViewModel : ViewModel() {
    private val _questionWord: MutableStateFlow<String> = MutableStateFlow("")
    val questionWord: StateFlow<String> = _questionWord.asStateFlow()

    private val _currentScore: MutableStateFlow<String> = MutableStateFlow("0")
    val currentScore: StateFlow<String> = _currentScore.asStateFlow()

    private val _solvedProblem: MutableStateFlow<String> = MutableStateFlow("0")
    val solvedProblem: StateFlow<String> = _solvedProblem.asStateFlow()

    private val _timerHour: MutableStateFlow<String> = MutableStateFlow("00")
    val timerHour: StateFlow<String> = _timerHour.asStateFlow()

    private val _timerMinute: MutableStateFlow<String> = MutableStateFlow("00")
    val timerMinute: StateFlow<String> = _timerMinute.asStateFlow()

}

package com.yourssu.unscramble.presentation.play

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class PlayViewModel : ViewModel() {
    private val _questionWord: MutableStateFlow<String> = MutableStateFlow("")
    val questionWord: MutableStateFlow<String> = _questionWord

    private val _currentScore: MutableStateFlow<String> = MutableStateFlow("0")
    val currentScore: MutableStateFlow<String> = _currentScore

    private val _solvedProblem: MutableStateFlow<String> = MutableStateFlow("0")
    val solvedProblem: MutableStateFlow<String> = _solvedProblem

    private val _timerHour: MutableStateFlow<String> = MutableStateFlow("00")
    val timerHour: MutableStateFlow<String> = _timerHour

    private val _timerMinute: MutableStateFlow<String> = MutableStateFlow("00")
    val timerMinute: MutableStateFlow<String> = _timerMinute

    private val _submitButtonText: MutableStateFlow<String> = MutableStateFlow("SUBMIT")
    val submitButtonText: MutableStateFlow<String> = _submitButtonText

    private val _skipButtonText: MutableStateFlow<String> = MutableStateFlow("SKIP")
    val skipButtonText: MutableStateFlow<String> = _skipButtonText
}

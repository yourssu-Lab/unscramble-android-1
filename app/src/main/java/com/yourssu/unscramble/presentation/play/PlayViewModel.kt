package com.yourssu.unscramble.presentation.play

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class PlayViewModel : ViewModel() {
    private val _questionWord: MutableStateFlow<String> = MutableStateFlow("")
    val questionWord: StateFlow<String> = _questionWord.asStateFlow()

    private val _currentScore: MutableStateFlow<Int> = MutableStateFlow(0)
    val currentScore: StateFlow<Int> = _currentScore.asStateFlow()

    private val _solvedProblem: MutableStateFlow<Int> = MutableStateFlow(1)
    val solvedProblem: StateFlow<Int> = _solvedProblem.asStateFlow()

    private val _timerHour: MutableStateFlow<String> = MutableStateFlow("00")
    val timerHour: StateFlow<String> = _timerHour.asStateFlow()

    private val _timerMinute: MutableStateFlow<String> = MutableStateFlow("00")
    val timerMinute: StateFlow<String> = _timerMinute.asStateFlow()

    // 유효성 판단에 따른 버튼 활성화 관련 코드
    // 사용자가 입력한 답안
    private val _inputAnswer: MutableStateFlow<String> = MutableStateFlow("")

    // 입력 답안 유효성 검사
    private val answerIsValid =
        _inputAnswer.map { input ->
            input.isNotBlank() && REGEX.matcher(input).matches()
        }

    // textField
    private val _textFieldIsNegative: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val textFieldIsNegative: StateFlow<Boolean> = _textFieldIsNegative.asStateFlow()

    // submit 버튼 활성화
    private val _submitBtnIsDisable: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val submitBtnIsDisable: StateFlow<Boolean> = _submitBtnIsDisable.asStateFlow()

    private val _navigateToEnd: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val navigateToEnd: StateFlow<Boolean> = _submitBtnIsDisable.asStateFlow()

    fun onPlayButtonClick() {
        if (solvedProblem.value == 9) {
            _navigateToEnd.value = true
        } else {
            _inputAnswer.value = ""
            nextProblem()
            checkValid()
        }
    }

    fun checkValid() {
        viewModelScope.launch {
            answerIsValid.collect { result ->
                _textFieldIsNegative.value = !result
                _submitBtnIsDisable.value = !result
            }
        }
    }

    fun setInputAnswer(answer: String) {
        _inputAnswer.value = answer
    }

    fun nextProblem() {
        _solvedProblem.value = (solvedProblem.value + 1)
        _inputAnswer.value = ""
    }
    companion object {
        private const val PATTERN = "^(?=.*[A-Za-z])[A-Za-z]{0,10}$"
        val REGEX: Pattern = Pattern.compile(PATTERN)
    }
}

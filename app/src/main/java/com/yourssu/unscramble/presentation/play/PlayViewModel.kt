package com.yourssu.unscramble.presentation.play

import android.text.Editable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yourssu.unscramble.repository.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class PlayViewModel @Inject constructor(
    private val quizRepository: QuizRepository,
) : ViewModel() {

    private val _currentScore: MutableStateFlow<Int> = MutableStateFlow(0)
    val currentScore: StateFlow<Int> = _currentScore.asStateFlow()

    private val _solvedProblem: MutableStateFlow<Int> = MutableStateFlow(1)
    val solvedProblem: StateFlow<Int> = _solvedProblem.asStateFlow()

    private val _formattedTime = MutableStateFlow("00:00")
    val formattedTime: StateFlow<String> = _formattedTime.asStateFlow()

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

    private val _navigateToEnd: MutableSharedFlow<Boolean> = MutableSharedFlow()
    val navigateToEnd: SharedFlow<Boolean> = _navigateToEnd.asSharedFlow()

    // 문제
    private val _questionScrambledFruitWord: MutableStateFlow<String> = MutableStateFlow("")
    val questionScrambledFruitWord: StateFlow<String> = _questionScrambledFruitWord.asStateFlow()

    private val _originalQuizWord: MutableStateFlow<String> = MutableStateFlow("")

    init {
        getQuizWord()
    }

    private fun getQuizWord() {
        viewModelScope.launch {
            val quizWord = quizRepository.getRandomQuizWord()
            _questionScrambledFruitWord.value = quizWord.scrambledQuizWord
            _originalQuizWord.value = quizWord.originalQuizWord
        }
    }

    fun answerChangedListner(s: Editable) {
        _inputAnswer.value = s.toString()
    }

    fun onPlayButtonClick() {
        if (_solvedProblem.value == 9) {
            checkUserAnswer()
            viewModelScope.launch {
                _navigateToEnd.emit(true)
            }
        } else {
            checkValid()
            checkUserAnswer()
            updatePlayView()
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

    private fun updatePlayView() {
        _solvedProblem.update { it + 1 }
        _inputAnswer.value = ""
        getQuizWord()
    }

    private fun checkUserAnswer() {
        viewModelScope.launch {
            if (_inputAnswer.value.uppercase() == _originalQuizWord.value.uppercase()) {
                _currentScore.update { it + 10 }
            }
        }
    }

    companion object {
        private const val PATTERN = "^(?=.*[A-Za-z])[A-Za-z]{0,10}$"
        val REGEX: Pattern = Pattern.compile(PATTERN)
    }

    // TODO : Fruit 네이밍 수정, 함수 및 변수 네이밍 수정, SKIP 시에는 정답이어도 점수 반영 X
}

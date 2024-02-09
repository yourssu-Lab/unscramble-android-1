package com.yourssu.unscramble.presentation.end

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EndViewModel : ViewModel() {
    val result = MutableLiveData("Time out!") //Todo 이 부분은 분기처리해야 함
    val score = MutableLiveData("70") //Todo 여기도 나중에 처리
}

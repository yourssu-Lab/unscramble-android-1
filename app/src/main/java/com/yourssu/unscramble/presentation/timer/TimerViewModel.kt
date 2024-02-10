package com.yourssu.unscramble.presentation.timer

import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Timer
import java.util.TimerTask

class TimerViewModel : ViewModel() {
    private var _isEnd: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isEnd: StateFlow<Boolean> = _isEnd

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

    fun startTimer() {
        var mSecond: Int = timerMinute.value * 60 + timerSecond.value

        val mTimer = Timer()
        // 반복적으로 사용할 TimerTask
        val mTimerTask = object : TimerTask() {
            override fun run() {
                val mHandler = Handler(Looper.getMainLooper())
                mHandler.postDelayed({
                    // 반복실행할 구문
                    mSecond--
                    Log.d("TimerFragment", "$mSecond")
                    if (mSecond <= 0) {
                        mTimer.cancel()
                        Log.d("TimerFragment", "타이머 종료")
                        _isEnd.value = true
                        Log.d("TimerFragment", isEnd.value.toString())

                    }
                }, 0)
            }
        }
        mTimer.schedule(mTimerTask, 0, 1000)
        Log.d("TimerFragment", "${mSecond}초 타이머 시작")
    }
}

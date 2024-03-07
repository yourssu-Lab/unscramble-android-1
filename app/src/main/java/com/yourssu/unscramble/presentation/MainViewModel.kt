package com.yourssu.unscramble.presentation

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Timer
import java.util.TimerTask
import javax.inject.Inject

@ViewModelScoped
class MainViewModel @Inject constructor() : ViewModel() {

    private val _isEnd: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isEnd: StateFlow<Boolean> = _isEnd

    private val _time: MutableStateFlow<Int> = MutableStateFlow(0)
    val time: StateFlow<Int> = _time

    private val _formattedTime = MutableSharedFlow<String>()
    val formattedTime: SharedFlow<String> = _formattedTime
    fun updateTime(time: Int) {
        _time.value = time
    }

    fun updateIsEnd() {
        _isEnd.value = false
    }

    suspend fun formattedTimer(cnt: Int) {
        val minutes = cnt / 60
        val remainingSeconds = cnt % 60

        _formattedTime.emit(String.format("%02d:%02d", minutes, remainingSeconds))
    }

    fun startTimer() {
        var cnt = _time.value

        val mTimer = Timer()
        // 반복적으로 사용할 TimerTask
        val mTimerTask = object : TimerTask() {
            override fun run() {
                suspend {
                    val mHandler = Handler(Looper.getMainLooper())

                    mHandler.postDelayed({
                        suspend {
                            // 반복실행할 구문
                            formattedTimer(cnt)
                            cnt--

                            Log.d("MainViewModel", "Formatted Time: ${_formattedTime}")

                            if (cnt <= 0) {
                                mTimer.cancel()
                                Log.d("MainViewModel", "타이머 종료")
                                _isEnd.value = true
                                Log.d("MainViewModel", isEnd.value.toString())

                            }
                        }
                    }, 0)
                }

            }
        }
        mTimer.schedule(mTimerTask, 0, 1000)
        Log.d("MainViewModel", "${cnt}초 타이머 시작")
    }
}
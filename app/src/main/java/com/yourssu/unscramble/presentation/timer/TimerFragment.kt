package com.yourssu.unscramble.presentation.timer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yourssu.unscramble.R
import com.yourssu.unscramble.databinding.FragmentTimerBinding
import com.yourssu.unscramble.util.base.BindFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TimerFragment : BindFragment<FragmentTimerBinding>() {
    private val viewModel: TimerViewModel by viewModels()

    override fun setBinding(layoutInflater: LayoutInflater): FragmentTimerBinding {
        return FragmentTimerBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnTimer.setOnClickListener {
            // Navigate to TimeFragment
            findNavController().navigate(R.id.playFragment)

            setTimer()
        }
    }

    fun setTimer() {
//        var mSecond: Int = viewModel.timerMinute.value * 60 + viewModel.timerSecond.value
//
//        val mTimer = Timer()
//        // 반복적으로 사용할 TimerTask
//        val mTimerTask = object : TimerTask() {
//            override fun run() {
//                val mHandler = Handler(Looper.getMainLooper())
//                mHandler.postDelayed({
//                    // 반복실행할 구문
//                    mSecond--
//                    Log.d("TimerFragment","$mSecond")
//                    if (mSecond <= 0) {
//                        mTimer.cancel()
//                        Log.d("TimerFragment","타이머 종료")
//                    }
////                    binding.tvTime.text = "$mSecond 초"
//                }, 0)
//            }
//        }
//        mTimer.schedule(mTimerTask, 0, 1000)
//        Log.d("TimerFragment","${mSecond}초 타이머 시작")
    }
}

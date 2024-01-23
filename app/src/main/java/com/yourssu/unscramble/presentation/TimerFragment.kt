package com.yourssu.unscramble.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import com.yourssu.unscramble.R
import com.yourssu.unscramble.databinding.FragmentTimerBinding
import com.yourssu.unscramble.util.base.BindFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TimerFragment : BindFragment<FragmentTimerBinding>() {

    override fun setBinding(layoutInflater: LayoutInflater): FragmentTimerBinding {
        return FragmentTimerBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnTimer.setOnClickListener {
            // Navigate to TimeFragment
            findNavController().navigate(R.id.playFragment)
        }
    }
}
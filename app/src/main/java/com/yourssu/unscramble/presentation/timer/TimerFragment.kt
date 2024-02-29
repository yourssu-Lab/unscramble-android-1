package com.yourssu.unscramble.presentation.timer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yourssu.unscramble.R
import com.yourssu.unscramble.databinding.FragmentTimerBinding
import com.yourssu.unscramble.presentation.MainViewModel
import com.yourssu.unscramble.util.base.BindFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TimerFragment : BindFragment<FragmentTimerBinding>() {
    private val mainViewModel: MainViewModel by activityViewModels()
    private val viewModel: TimerViewModel by viewModels()

    override fun setBinding(layoutInflater: LayoutInflater): FragmentTimerBinding {
        return FragmentTimerBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnTimer.setOnClickListener {
            findNavController().navigate(R.id.playFragment)

            mainViewModel.updateTime(viewModel.getTotalTime())

        }
    }
}

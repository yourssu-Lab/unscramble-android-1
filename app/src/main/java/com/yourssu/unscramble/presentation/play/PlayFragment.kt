package com.yourssu.unscramble.presentation.play

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.yourssu.unscramble.R
import com.yourssu.unscramble.databinding.FragmentPlayBinding
import com.yourssu.unscramble.presentation.timer.TimerViewModel
import com.yourssu.unscramble.util.base.BindFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PlayFragment : BindFragment<FragmentPlayBinding>() {
    private val playViewModel: PlayViewModel by viewModels()
    private val timerViewModel: TimerViewModel by viewModels()

    override fun setBinding(layoutInflater: LayoutInflater): FragmentPlayBinding {
        return FragmentPlayBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = playViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnSubmit.setOnClickListener {
            findNavController().navigate(R.id.endFragment)
        }


        Log.d("PlayFragment", timerViewModel.isEnd.value.toString())



        viewLifecycleOwner.lifecycleScope.launch {
            timerViewModel.isEnd
                .collectLatest { isEnd ->
                    Log.d("PlayFragment", isEnd.toString())
                    if (isEnd) {
                        findNavController().navigate(R.id.endFragment)
                    }
                }
        }
    }
}

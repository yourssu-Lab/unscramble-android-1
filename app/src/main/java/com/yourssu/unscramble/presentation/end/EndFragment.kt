package com.yourssu.unscramble.presentation.end

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yourssu.unscramble.R
import com.yourssu.unscramble.databinding.FragmentEndBinding
import com.yourssu.unscramble.presentation.MainViewModel
import com.yourssu.unscramble.util.base.BindFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EndFragment : BindFragment<FragmentEndBinding>() {
    private val mainViewModel: MainViewModel by activityViewModels()
    private val viewModel: EndViewModel by viewModels()

    override fun setBinding(layoutInflater: LayoutInflater): FragmentEndBinding {
        return FragmentEndBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.run {
            btnRetry.setOnClickListener {
                findNavController().navigate(R.id.timerFragment)
                mainViewModel.updateIsEnd()
            }

            btnHome.setOnClickListener {
                findNavController().navigate(R.id.startFragment)
                mainViewModel.updateIsEnd()
            }
        }
    }
}
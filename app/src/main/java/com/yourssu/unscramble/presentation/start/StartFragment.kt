package com.yourssu.unscramble.presentation.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yourssu.unscramble.R
import com.yourssu.unscramble.databinding.FragmentStartBinding
import com.yourssu.unscramble.util.base.BindFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : BindFragment<FragmentStartBinding>() {

    override fun setBinding(layoutInflater: LayoutInflater): FragmentStartBinding {
        return FragmentStartBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.timerFragment)
        }
    }
}
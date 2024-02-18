package com.yourssu.unscramble.presentation.play

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.yourssu.unscramble.R
import com.yourssu.unscramble.databinding.FragmentPlayBinding
import com.yourssu.unscramble.util.base.BindFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PlayFragment : BindFragment<FragmentPlayBinding>() {
    private val viewModel: PlayViewModel by viewModels()

    override fun setBinding(layoutInflater: LayoutInflater): FragmentPlayBinding {
        return FragmentPlayBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.checkValid()
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnSubmit.setOnClickListener {
            viewModel.onPlayButtonClick()
            lifecycleScope.launch {
                viewModel.navigateToEnd.collect { navigateToEnd ->
                    if (navigateToEnd) {
                        findNavController().navigate(R.id.endFragment)
                    }
                }
            }
            binding.etAnswer.text.clear()
        }
        binding.btnSkip.setOnClickListener {
            viewModel.onPlayButtonClick()
            lifecycleScope.launch {
                viewModel.navigateToEnd.collect { navigateToEnd ->
                    if (navigateToEnd) {
                        findNavController().navigate(R.id.endFragment)
                    }
                }
            }
            binding.etAnswer.text.clear()
        }
        binding.etAnswer.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int,
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.setInputAnswer(s.toString())
            }
        })
    }
}

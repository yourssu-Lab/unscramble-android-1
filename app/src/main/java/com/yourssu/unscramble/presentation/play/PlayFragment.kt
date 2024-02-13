package com.yourssu.unscramble.presentation.play

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yourssu.unscramble.R
import com.yourssu.unscramble.databinding.FragmentPlayBinding
import com.yourssu.unscramble.util.base.BindFragment
import dagger.hilt.android.AndroidEntryPoint

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

        navigateView()
        viewModel.checkValid()
        listenTextFieldChanged()
    }

    private fun navigateView() {
        binding.run {
            btnSubmit.setOnClickListener {
                if (viewModel!!.solvedProblem.value == 9) {
                    findNavController().navigate(R.id.endFragment)
                } else {
                    binding.etAnswer.text.clear()
                    viewModel!!.nextProblem()
                    viewModel!!.checkValid()
                }
            }
            btnSkip.setOnClickListener {
                findNavController().navigate(R.id.endFragment)
            }
        }
    }

    private fun listenTextFieldChanged() {
        binding.etAnswer.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.setInputAnswer(s.toString())
            }
        })
    }
}

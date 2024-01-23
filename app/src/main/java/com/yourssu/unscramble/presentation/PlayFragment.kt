package com.yourssu.unscramble.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yourssu.unscramble.R
import com.yourssu.unscramble.databinding.FragmentEndBinding
import com.yourssu.unscramble.databinding.FragmentPlayBinding
import com.yourssu.unscramble.util.base.BindFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PlayFragment : BindFragment<FragmentPlayBinding>() {

    override fun setBinding(layoutInflater: LayoutInflater): FragmentPlayBinding {
        return FragmentPlayBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
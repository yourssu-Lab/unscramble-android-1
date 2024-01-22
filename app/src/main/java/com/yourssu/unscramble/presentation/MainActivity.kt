package com.yourssu.unscramble.presentation

import android.os.Bundle
import android.view.LayoutInflater
import com.yourssu.unscramble.util.base.BindActivity
import com.yourssu.unscramble.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindActivity<ActivityMainBinding>() {

    override fun setBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}

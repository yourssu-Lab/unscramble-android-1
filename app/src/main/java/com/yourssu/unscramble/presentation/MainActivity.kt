package com.yourssu.unscramble.presentation

import android.os.Bundle
import android.view.LayoutInflater
import com.yourssu.unscramble.base.BindActivity
import com.yourssu.unscramble.databinding.ActivityMainBinding

class MainActivity : BindActivity<ActivityMainBinding>() {

    override fun setBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}

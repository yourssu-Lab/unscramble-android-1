package com.yourssu.unscramble.presentation

import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.yourssu.design.system.atom.BoxButton
import com.yourssu.design.system.foundation.Typo
import com.yourssu.design.undercarriage.base.TextField
import com.yourssu.unscramble.R

class StartViewModel: ViewModel() {
    val title = MutableLiveData("UNSCRAMBLE")
    val btn = MutableLiveData("START")
}

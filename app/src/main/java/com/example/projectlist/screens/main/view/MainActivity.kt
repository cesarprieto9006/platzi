package com.example.projectlist.screens.main.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.projectlist.R
import com.example.projectlist.databinding.ActivityMainBinding
import com.example.projectlist.screens.BaseActivity
import com.example.projectlist.screens.main.viewmodel.MainViewModel

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel: MainViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        setBaseViewModel(viewModel)

    }
}
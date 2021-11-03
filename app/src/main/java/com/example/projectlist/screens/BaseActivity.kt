package com.example.projectlist.screens

import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

open class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var baseViewModel: BaseViewModel? = null

    fun setBaseViewModel(baseViewModel: BaseViewModel?) {
        this.baseViewModel = baseViewModel
    }

}

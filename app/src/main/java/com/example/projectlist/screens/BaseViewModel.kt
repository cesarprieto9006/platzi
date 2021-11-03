package com.example.projectlist.screens

import androidx.lifecycle.ViewModel


open class BaseViewModel: ViewModel() {

    private var baseViewModel: BaseViewModel? = null

    fun setBaseViewModel(baseViewModel: BaseViewModel) {
        this.baseViewModel = baseViewModel
    }

}

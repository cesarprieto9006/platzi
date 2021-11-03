package com.example.projectlist.screens.main.viewmodel


import com.example.projectlist.screens.BaseViewModel
import com.example.projectlist.screens.main.repository.MainRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MainRepository) :
    BaseViewModel() {


}
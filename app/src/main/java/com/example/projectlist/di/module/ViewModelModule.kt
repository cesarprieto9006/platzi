package com.example.projectlist.di.module

import androidx.lifecycle.ViewModel
import com.example.projectlist.di.annotation.ViewModelKey
import com.example.projectlist.screens.main.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainViewModel): ViewModel

}

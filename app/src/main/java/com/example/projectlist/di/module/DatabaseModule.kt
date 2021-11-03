package com.example.projectlist.di.module

import android.content.Context
import com.example.projectlist.database.ProjectDataBase
import com.example.projectlist.database.dao.FishDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): ProjectDataBase = ProjectDataBase.getDatabase(context)


    @Provides
    @Singleton
    fun provideHistoryDao(database: ProjectDataBase): FishDao = database.personalDao()
}
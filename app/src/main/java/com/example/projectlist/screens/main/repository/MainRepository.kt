package com.example.projectlist.screens.main.repository

import androidx.lifecycle.LiveData
import com.example.projectlist.database.dao.FishDao
import com.example.projectlist.network.ApiService
import com.example.projectlist.screens.main.model.DataFish
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.Executors
import javax.inject.Inject
import kotlin.collections.ArrayList

class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val fishDao: FishDao
) {
    fun getData(): Observable<ArrayList<DataFish>> {
        return apiService.getData()
    }

    fun saveData(personalData: ArrayList<DataFish>) {
        Executors.newSingleThreadExecutor().execute {
            fishDao.updateData(personalData)
        }
    }

    fun getDataBase(): LiveData<List<DataFish>> =
        fishDao.getFishData()
}
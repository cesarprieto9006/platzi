package com.example.projectlist.network

import com.example.projectlist.screens.main.model.DataFish
import com.example.projectlist.utils.SuperAppConstants
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiService {
    @GET(SuperAppConstants.EP_SPECIES)
    fun getData(): Observable<ArrayList<DataFish>>
}
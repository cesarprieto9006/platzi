package com.example.projectlist.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projectlist.screens.main.model.DataFish


@Dao
interface FishDao {

    @Query("SELECT * FROM fish_table")
    fun getFishData(
    ): LiveData<List<DataFish>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFishData(arrayData: ArrayList<DataFish>)

    @Query("DELETE FROM fish_table")
    fun deleteAllData()

    @Transaction
    fun updateData(arrayData: ArrayList<DataFish>) {
        deleteAllData()
        insertFishData(arrayData)
    }

}
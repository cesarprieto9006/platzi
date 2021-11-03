package com.example.projectlist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.projectlist.database.dao.FishDao
import com.example.projectlist.screens.main.model.DataFish
import com.example.projectlist.utils.Converters

@Database(
    entities = [DataFish::class],
    version = ProjectDataBase.DB_VERSION,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ProjectDataBase : RoomDatabase() {

    abstract fun personalDao(): FishDao

    companion object {

        @Volatile
        private var INSTANCE: ProjectDataBase? = null

        private val LOCK = Any()
        private var DB_NAME = "projectdatabase"
        const val DB_VERSION = 1

        fun getDatabase(context: Context): ProjectDataBase {
            return INSTANCE ?: synchronized(LOCK) {
                val instance = Room
                    .databaseBuilder(
                        context.applicationContext,
                        ProjectDataBase::class.java,
                        DB_NAME
                    )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
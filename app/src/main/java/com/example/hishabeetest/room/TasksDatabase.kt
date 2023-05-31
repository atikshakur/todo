package com.example.hishabeetest.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskItemDatabase : RoomDatabase()
{
    abstract fun taskItemDao(): TaskItemDao

    companion object
    {
        @Volatile
        private var INSTANCE: TaskItemDatabase? = null

        fun getDatabase(context: Context): TaskItemDatabase
        {
            return INSTANCE ?: synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskItemDatabase::class.java,
                    "tasks_item_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
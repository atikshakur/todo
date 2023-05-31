package com.example.hishabeetest.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskItemDao
{
    @Query("SELECT * FROM tasks ORDER BY id ASC")
    fun allTasks(): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(taskItem: Task)

    @Update
    fun updateTaskItem(taskItem: Task)

}
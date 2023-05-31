package com.example.hishabeetest.room

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class TaskItemRepository(private val taskItemDao: TaskItemDao)
{
    val allTaskItems: Flow<List<Task>> = taskItemDao.allTasks()

    @WorkerThread
    suspend fun insertTaskItem(taskItem: Task)
    {
        taskItemDao.insertTask(taskItem)
    }

    @WorkerThread
    suspend fun updateTaskItem(taskItem: Task)
    {
        taskItemDao.updateTaskItem(taskItem)
    }
}
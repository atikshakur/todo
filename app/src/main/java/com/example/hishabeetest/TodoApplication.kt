package com.example.hishabeetest

import android.app.Application
import com.example.hishabeetest.room.TaskItemDatabase
import com.example.hishabeetest.room.TaskItemRepository

class TodoApplication : Application()
{
    private val database by lazy { TaskItemDatabase.getDatabase(this) }
    val repository by lazy { TaskItemRepository(database.taskItemDao()) }
}
package com.example.hishabeetest.adapter

import com.example.hishabeetest.room.Task

interface TaskItemClickListener
{
    fun completeTaskItem(taskItem: Task)
}
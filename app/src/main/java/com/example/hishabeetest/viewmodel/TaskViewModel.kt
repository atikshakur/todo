package com.example.hishabeetest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.*
import com.example.hishabeetest.room.Task
import com.example.hishabeetest.room.TaskItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskItemRepository): ViewModel()
{
    val taskItems: LiveData<List<Task>> = repository.allTaskItems.asLiveData()

    fun addTaskItem(taskItem: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertTaskItem(taskItem)
    }

    fun setCompleted(taskItem: Task) = viewModelScope.launch(Dispatchers.IO) {
        taskItem.completed = true
        repository.updateTaskItem(taskItem)
    }
}

class TaskItemModelFactory(private val repository: TaskItemRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java))
            return TaskViewModel(repository) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
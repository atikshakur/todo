package com.example.hishabeetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hishabeetest.adapter.TaskItemAdapter
import com.example.hishabeetest.adapter.TaskItemClickListener
import com.example.hishabeetest.databinding.ActivityMainBinding
import com.example.hishabeetest.room.Task
import com.example.hishabeetest.viewmodel.TaskItemModelFactory
import com.example.hishabeetest.viewmodel.TaskViewModel

class MainActivity : AppCompatActivity(), TaskItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val taskViewModel: TaskViewModel by viewModels {
        TaskItemModelFactory((application as TodoApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newTaskButton.setOnClickListener {
            NewTaskSheet().show(supportFragmentManager, "newTaskTag")
        }
        setRecyclerView()
    }

    private fun setRecyclerView()
    {

        taskViewModel.taskItems.observe(this){
            binding.tasksRecyclerview.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = TaskItemAdapter(it, this@MainActivity)
            }
        }
    }


    override fun completeTaskItem(taskItem: Task)
    {
        taskViewModel.setCompleted(taskItem)
    }
}
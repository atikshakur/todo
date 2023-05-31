package com.example.hishabeetest.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hishabeetest.databinding.TaskItemBinding
import com.example.hishabeetest.room.Task

class TaskItemAdapter(
    private val taskItems: List<Task>,
    private val clickListener: TaskItemClickListener
): RecyclerView.Adapter<TaskItemAdapter.TaskItemViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = TaskItemBinding.inflate(from, parent, false)
        return TaskItemViewHolder(parent.context, binding, clickListener)
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        holder.bindTaskItem(taskItems[position])
    }

    override fun getItemCount(): Int = taskItems.size

    class TaskItemViewHolder(
        private val context: Context,
        private val binding: TaskItemBinding,
        private val clickListener: TaskItemClickListener
    ): RecyclerView.ViewHolder(binding.root)
    {

        fun bindTaskItem(task: Task)
        {
            binding.task.text = task.task

            if (task.completed){
                binding.task.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }

            binding.taskCheck.setImageResource(task.imageResource())
            binding.taskCheck.setColorFilter(task.imageColor(context))

            binding.taskCheck.setOnClickListener{
                clickListener.completeTaskItem(task)
            }
        }
    }
}
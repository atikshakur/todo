package com.example.hishabeetest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hishabeetest.databinding.FragmentNewTaskSheetBinding
import com.example.hishabeetest.room.Task
import com.example.hishabeetest.viewmodel.TaskViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewTaskSheet : BottomSheetDialogFragment() {

    private var _binding: FragmentNewTaskSheetBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewTaskSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        taskViewModel = ViewModelProvider(requireActivity())[TaskViewModel::class.java]

        binding.saveButton.setOnClickListener {
            saveTask()
        }

    }

    private fun saveTask()
    {
        val task = binding.task.text.toString()
        val newTask = Task(id = null, task = task, completed = false)
        taskViewModel.addTaskItem(newTask)

        binding.task.setText("")
        dismiss()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.hishabeetest.room

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hishabeetest.R

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name = "task") var task: String,
    @ColumnInfo(name = "isCompleted") var completed: Boolean
)
{
    fun imageResource(): Int = if(completed) R.drawable.checked_24 else R.drawable.unchecked_24
    fun imageColor(context: Context): Int = if(completed) completed(context) else incomplete(context)

    private fun incomplete(context: Context) = ContextCompat.getColor(context, R.color.grey)
    private fun completed(context: Context) = ContextCompat.getColor(context, R.color.blue)
}

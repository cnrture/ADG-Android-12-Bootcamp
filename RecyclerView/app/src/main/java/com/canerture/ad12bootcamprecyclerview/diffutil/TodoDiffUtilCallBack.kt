package com.canerture.ad12bootcamprecyclerview.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.canerture.ad12bootcamprecyclerview.recyclerview.TodoModel

class TodoDiffUtilCallBack : DiffUtil.ItemCallback<TodoModel>() {

    override fun areItemsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
        return oldItem.todoId == newItem.todoId
    }

    override fun areContentsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
        return oldItem == newItem
    }
}
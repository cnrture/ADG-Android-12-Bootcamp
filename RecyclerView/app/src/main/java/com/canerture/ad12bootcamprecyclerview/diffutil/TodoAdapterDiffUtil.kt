package com.canerture.ad12bootcamprecyclerview.diffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.canerture.ad12bootcamprecyclerview.recyclerview.TodoModel
import com.canerture.ad12bootcamprecyclerview.databinding.TodoItemDesignBinding

class TodoAdapterDiffUtil :
    ListAdapter<TodoModel, TodoAdapterDiffUtil.ToDoViewHolder>(TodoDiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val todoItemDesignBinding =
            TodoItemDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ToDoViewHolder(todoItemDesignBinding)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ToDoViewHolder(private val todoItemDesignBinding: TodoItemDesignBinding) :
        RecyclerView.ViewHolder(todoItemDesignBinding.root) {

        fun bind(todo: TodoModel) {

            todoItemDesignBinding.todoItem = todo
        }
    }
}
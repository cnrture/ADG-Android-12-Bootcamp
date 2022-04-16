package com.canerture.ad12bootcamprecyclerview.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canerture.ad12bootcamprecyclerview.databinding.TodoItemDesignBinding

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private val todoList = ArrayList<TodoModel>()

    var onTodoClick: (TodoModel) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val todoItemDesignBinding =
            TodoItemDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(todoItemDesignBinding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoList[position], onTodoClick)
    }

    class TodoViewHolder(private val todoItemDesignBinding: TodoItemDesignBinding) :
        RecyclerView.ViewHolder(todoItemDesignBinding.root) {

        fun bind(todo: TodoModel, onTodoClick: (TodoModel) -> Unit = {}) {

            with(todoItemDesignBinding) {

                todoItem = todo

                cbTodo.setOnCheckedChangeListener { compoundButton, isChecked ->
                    if (isChecked) onTodoClick(todo)
                }
            }
        }
    }

    override fun getItemCount(): Int = todoList.size

    fun updateList(updatedList: List<TodoModel>) {
        todoList.clear()
        todoList.addAll(updatedList)
        notifyDataSetChanged()
    }
}
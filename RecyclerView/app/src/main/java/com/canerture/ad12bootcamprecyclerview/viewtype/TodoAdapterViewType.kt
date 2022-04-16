package com.canerture.ad12bootcamprecyclerview.viewtype

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canerture.ad12bootcamprecyclerview.databinding.HeaderDesignBinding
import com.canerture.ad12bootcamprecyclerview.databinding.TodoItemDesignViewTypeBinding

private const val TYPE_HEADER = 0
private const val TYPE_TODO = 1

class ToDoAdapterViewType() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val todoList = ArrayList<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {

            TYPE_TODO -> ToDoViewHolder(
                TodoItemDesignViewTypeBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )

            TYPE_HEADER -> HeaderViewHolder(
                HeaderDesignBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> throw IllegalArgumentException("Invalid ViewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ToDoViewHolder -> holder.bind(todoList[position] as DataItem.TodoItem)
            is HeaderViewHolder -> holder.bind(todoList[position] as DataItem.HeaderItem)
        }
    }

    class ToDoViewHolder(private val todoItemDesignViewTypeBinding: TodoItemDesignViewTypeBinding) :
        RecyclerView.ViewHolder(todoItemDesignViewTypeBinding.root) {

        fun bind(todo: DataItem.TodoItem) {

            todoItemDesignViewTypeBinding.todoItem = todo
        }
    }

    class HeaderViewHolder(private val headerDesignBinding: HeaderDesignBinding) :
        RecyclerView.ViewHolder(headerDesignBinding.root) {

        fun bind(header: DataItem.HeaderItem) {

            headerDesignBinding.headerItem = header
        }
    }

    override fun getItemCount() = todoList.size

    override fun getItemViewType(position: Int): Int {
        return when (todoList[position]) {
            is DataItem.TodoItem -> TYPE_TODO
            is DataItem.HeaderItem -> TYPE_HEADER
            else -> throw IllegalArgumentException("Invalid Data")
        }
    }

    fun updateList(updatedList: List<Any>) {
        todoList.clear()
        todoList.addAll(updatedList)
        notifyDataSetChanged()
    }
}
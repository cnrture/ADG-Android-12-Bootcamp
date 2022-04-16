package com.canerture.ad12bootcamprecyclerview.viewtype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.canerture.ad12bootcamprecyclerview.databinding.ActivityMainBinding

class MainActivityViewType : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val todoAdapterViewType by lazy { ToDoAdapterViewType() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoList = TodoDbViewType.getTodos()

        todoAdapterViewType.updateList(todoList)

        binding.rvTodo.apply {

            layoutManager =
                LinearLayoutManager(this@MainActivityViewType, LinearLayoutManager.VERTICAL, false)
            //layoutManager = GridLayoutManager(this@MainActivity, 2, GridLayoutManager.VERTICAL, false)
            //layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = todoAdapterViewType
        }
    }
}
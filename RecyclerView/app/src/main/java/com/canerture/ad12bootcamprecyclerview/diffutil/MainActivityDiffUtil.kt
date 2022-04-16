package com.canerture.ad12bootcamprecyclerview.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.canerture.ad12bootcamprecyclerview.databinding.ActivityMainBinding

class MainActivityDiffUtil : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val todoAdapterDiffUtil by lazy { TodoAdapterDiffUtil() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoList = TodoDbDiffUtil.getTodos()

        binding.rvTodo.apply {

            layoutManager =
                LinearLayoutManager(this@MainActivityDiffUtil, LinearLayoutManager.VERTICAL, false)
            //layoutManager = GridLayoutManager(this@MainActivity, 2, GridLayoutManager.VERTICAL, false)
            //layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = todoAdapterDiffUtil
        }

        todoAdapterDiffUtil.submitList(todoList)
    }
}
package com.canerture.ad12bootcamprecyclerview.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.canerture.ad12bootcamprecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val todoAdapter by lazy { TodoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoList = TodoDb.getTodos()

        todoAdapter.updateList(todoList)

        binding.rvTodo.apply {

            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            //layoutManager = GridLayoutManager(this@MainActivity, 2, GridLayoutManager.VERTICAL, false)
            //layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = todoAdapter
        }

        todoAdapter.onTodoClick = {
            Toast.makeText(this, it.toDoText, Toast.LENGTH_SHORT).show()
        }
    }
}
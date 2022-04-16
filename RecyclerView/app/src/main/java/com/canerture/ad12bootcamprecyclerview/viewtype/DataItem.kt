package com.canerture.ad12bootcamprecyclerview.viewtype

sealed class DataItem {

    data class TodoItem(val todoId: Int, val toDoText: String) : DataItem()
    data class HeaderItem(val headerText: String) : DataItem()
}

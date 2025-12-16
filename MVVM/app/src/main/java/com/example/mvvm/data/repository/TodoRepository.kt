package com.example.mvvm.data.repository

import com.example.mvvm.data.model.Todo
class TodoRepository {
    private val todos = mutableListOf<Todo>()

    fun getTodos():List<Todo> = todos

    fun addTodos(todo: Todo){
        todos.add(todo)
    }
    fun deleteTodos(todo: Todo){
        todos.remove(todo)
    }
}
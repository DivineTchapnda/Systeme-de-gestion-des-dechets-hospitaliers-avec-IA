package com.example.mvvm.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mvvm.data.model.Todo
import com.example.mvvm.data.repository.TodoRepository

class TodoViewModel : ViewModel(){

    private val repository = TodoRepository()
    private val _todos = mutableStateOf<List<Todo>>(emptyList())
    val todos : State<List<Todo>> = _todos

    private var nextId = 0

    fun loadTodo()
    {
        _todos.value = repository.getTodos()

    }
    fun addToDo (title :String){
        val todo = Todo(nextId++ , title )
        repository.addTodos(todo)
        loadTodo()
    }

    fun deleteTodo(todo : Todo)
    {
        repository.deleteTodos(todo)
        loadTodo()
    }
}
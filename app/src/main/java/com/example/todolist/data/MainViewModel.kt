package com.example.todolist.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.data.TodoItem
import com.example.todolist.data.TodoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class MainViewModel(
    // 1. ViewModel Initialization
    private val repository: TodoRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    // 2. Todo Data Flow
    val todos = repository.allTodos

    // 3. Todo Operations
    fun addTodo(todo: String) =
        viewModelScope.launch(ioDispatcher) { repository.insert(TodoItem(title = todo)) }

    fun toggleTodo(todoItem: TodoItem) =
        viewModelScope.launch(ioDispatcher) { repository.insert(todoItem.copy(isDone = !todoItem.isDone)) }

    fun removeTodo(todoItem: TodoItem) =
        viewModelScope.launch(ioDispatcher) { repository.delete(todoItem) }
}
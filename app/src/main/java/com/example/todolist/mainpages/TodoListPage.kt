package com.example.todolist.mainpages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.todolist.composables.TodoInputBar
import com.example.todolist.composables.TodoItemsContainer
import com.example.todolist.data.AppDatabase
import com.example.todolist.data.MainViewModel
import com.example.todolist.data.TodoRepository
import com.example.todolist.ui.constants.OverlappingHeight
import kotlinx.coroutines.Dispatchers

@Composable
fun TodoListPage(db: AppDatabase) {
    // Manual MainViewModel Creation
    val mainViewModel = MainViewModel(TodoRepository(db.todoDao()), ioDispatcher = Dispatchers.IO)
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        TodoItemsContainer(
            todoItemsFlow = mainViewModel.todos,
            // 3. Method Reference Expression
            onItemClick = mainViewModel::toggleTodo,
            onItemDelete = mainViewModel::removeTodo,
            overlappingElementsHeight = OverlappingHeight
        )
        TodoInputBar(
            modifier = Modifier.align(Alignment.BottomStart),
            onAddButtonClick = mainViewModel::addTodo
        )
    }
}
package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.example.todolist.composables.TodoInputBar
import com.example.todolist.composables.TodoItemsContainer
import com.example.todolist.data.AppDatabase
import com.example.todolist.data.MainViewModel
import com.example.todolist.data.TodoRepository
import com.example.todolist.ui.constants.OverlappingHeight
import kotlinx.coroutines.Dispatchers

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Manual DB Creation
        val db = Room
            .databaseBuilder(applicationContext, AppDatabase::class.java, "todo-db")
            .build()
        // 2. Manual MainViewModel Creation
        val mainViewModel = MainViewModel(TodoRepository(db.todoDao()), ioDispatcher = Dispatchers.IO)
        setContent {
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
    }
}

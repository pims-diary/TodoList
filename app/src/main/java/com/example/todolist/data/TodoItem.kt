package com.example.todolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class TodoItem(
    @PrimaryKey(autoGenerate = false)
    val id: UUID = UUID.randomUUID(),
    val title: String,
    var isDone: Boolean = false
)
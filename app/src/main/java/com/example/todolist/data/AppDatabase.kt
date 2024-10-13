package com.example.todolist.data

import androidx.room.Database
import androidx.room.RoomDatabase

// 1. Database Annotation
@Database(entities = [TodoItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    // 2. Abstract Functions
    abstract fun todoDao(): TodoDao
}

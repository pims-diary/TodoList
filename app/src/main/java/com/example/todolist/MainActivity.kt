package com.example.todolist

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.room.Room
import com.example.todolist.data.AppDatabase
import com.example.todolist.mainpages.TabScreen
import com.example.todolist.mainpages.TodoListPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Manual DB Creation
        val db = Room
            .databaseBuilder(applicationContext, AppDatabase::class.java, "todo-db")
            .build()

        // Use SplashScreen API if the device is running Android 12 or later
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            installSplashScreen()
        }

        setContent {
            TabScreen(database = db)
        }
    }
}

package com.example.todolist.mainpages

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.todolist.composables.OpenDialer

@Composable
fun AboutPage() {
    Column {
        OpenDialer(phoneNumber = "+64284307422")
    }
}
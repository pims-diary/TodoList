package com.example.todolist.data

import java.time.LocalDate

// Data class to represent an event
data class StudentEvent(
    val summary: String,
    val courseName: String? = null,
    val date: LocalDate,
    val time: String,
    val shortInfo: String,
    val imageRes: Int? = null // Optional image
)
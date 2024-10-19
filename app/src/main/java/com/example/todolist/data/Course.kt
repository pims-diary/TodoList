package com.example.todolist.data

data class Course(
    val name: String,
    val code: String,
    val professor: String,
    val duration: String,
    val credits: Int,
    val summary: String,
    val imageRes: Int // Image resource ID for the course image
)
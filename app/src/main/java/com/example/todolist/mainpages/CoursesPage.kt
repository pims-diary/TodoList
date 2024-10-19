package com.example.todolist.mainpages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.todolist.R
import com.example.todolist.composables.CourseTile
import com.example.todolist.data.Course

val courses = listOf(
    Course(
        name = "Introduction to Artificial Intelligence",
        code = "CS101",
        professor = "Dr. John Doe",
        duration = "4 months",
        credits = 4,
        summary = "An introduction to AI covering machine learning, neural networks, and natural language processing.",
        imageRes = R.drawable.sample_image_1
    ),
    Course(
        name = "Data Structures and Algorithms",
        code = "CS102",
        professor = "Dr. Jane Smith",
        duration = "3 months",
        credits = 3,
        summary = "This course covers essential data structures and algorithms for problem solving.",
        imageRes = R.drawable.sample_image_2
    ),
    // Add more courses as needed
)

@Composable
fun CoursesPage(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        courses.forEach { course ->
            item {
                CourseTile(course = course) {
                    // Navigate to CourseDetailScreen, passing course details
                    navController.navigate("courseDetail/${course.code}")
                }
            }
        }
    }
}
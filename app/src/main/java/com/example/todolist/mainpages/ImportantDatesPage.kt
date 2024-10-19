package com.example.todolist.mainpages

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import com.example.todolist.R
import com.example.todolist.composables.event.EventsScreen
import com.example.todolist.data.StudentEvent
import java.time.LocalDate


// Sample data for events
@RequiresApi(Build.VERSION_CODES.O)
val events = listOf(
    StudentEvent(
        summary = "Project Presentation Submission",
        courseName = "CS101",
        date = LocalDate.of(2024, 4, 12),
        time = "10:00 AM",
        shortInfo = "Submit your final project presentation to the course instructor.",
        imageRes = R.drawable.sample_image_1
    ),
    StudentEvent(
        summary = "Mathematics Final Exam",
        courseName = "MATH202",
        date = LocalDate.of(2024, 5, 25),
        time = "2:00 PM",
        shortInfo = "The final exam will cover chapters 1-10. Bring your calculators.",
        imageRes = R.drawable.sample_image_2
    ),
    StudentEvent(
        summary = "Group Discussion on AI",
        courseName = "CS305",
        date = LocalDate.of(2024, 2, 15),
        time = "11:00 AM",
        shortInfo = "A discussion on recent trends in artificial intelligence with peer review.",
        imageRes = R.drawable.sample_image_3
    ),
    // Add more events here
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ImportantDatesPage() {
    EventsScreen(events = events)
}
package com.example.todolist.mainpages

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

// Sample class schedule data
data class ClassSchedule(
    val className: String,
    val time: String
)

// Example timetable data (Monday to Friday)
val timetable = mapOf(
    "Monday" to listOf(
        ClassSchedule("Math", "9:00 AM - 10:00 AM"),
        ClassSchedule("History", "10:30 AM - 11:30 AM")
    ),
    "Tuesday" to listOf(
        ClassSchedule("Physics", "9:00 AM - 10:00 AM"),
        ClassSchedule("Chemistry", "10:30 AM - 11:30 AM")
    ),
    "Wednesday" to listOf(
        ClassSchedule("Biology", "9:00 AM - 10:00 AM"),
        ClassSchedule("Geography", "10:30 AM - 11:30 AM")
    ),
    "Thursday" to listOf(
        ClassSchedule("Computer Science", "9:00 AM - 10:00 AM"),
        ClassSchedule("Art", "10:30 AM - 11:30 AM")
    ),
    "Friday" to listOf(
        ClassSchedule("Physical Education", "9:00 AM - 10:00 AM"),
        ClassSchedule("Music", "10:30 AM - 11:30 AM")
    )
)

// Composable function to display the timetable
@Composable
fun TimetableScreen(timetable: Map<String, List<ClassSchedule>>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        timetable.forEach { (day, classList) ->
            item {
                DaySchedule(day = day, classList = classList)
            }
        }
    }
}

// Composable function for a single day's schedule
@Composable
fun DaySchedule(day: String, classList: List<ClassSchedule>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Day of the week title
        Text(
            text = day,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        // List of classes for the day
        classList.forEach { classSchedule ->
            ClassRow(classSchedule)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

// Composable function for each class row
@Composable
fun ClassRow(classSchedule: ClassSchedule) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Class name
            Text(
                text = classSchedule.className,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
            // Class time
            Text(
                text = classSchedule.time,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}
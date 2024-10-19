package com.example.todolist.mainpages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolist.composables.list.CollectiveListRow
import com.example.todolist.data.TimeSchedule


// Example timetable data (Monday to Friday)
val timetable = mapOf(
    "Monday" to listOf(
        TimeSchedule("Mobile Development", "9:00 AM - 10:00 AM"),
        TimeSchedule("Mathematics", "10:30 AM - 11:30 AM")
    ),
    "Tuesday" to listOf(
        TimeSchedule("Requirement Modeling", "9:00 AM - 10:00 AM"),
        TimeSchedule("Information System Security", "10:30 AM - 11:30 AM")
    ),
    "Wednesday" to listOf(
        TimeSchedule("Information System Security", "9:00 AM - 10:00 AM"),
        TimeSchedule("Mathematics", "10:30 AM - 11:30 AM")
    ),
    "Thursday" to listOf(
        TimeSchedule("IT Club", "9:00 AM - 10:00 AM"),
        TimeSchedule("Student Council", "10:30 AM - 11:30 AM")
    ),
    "Friday" to listOf(
        TimeSchedule("Requirement Modeling", "9:00 AM - 10:00 AM"),
        TimeSchedule("Mobile Development", "10:30 AM - 11:30 AM")
    )
)

// Composable function to display the timetable
@Composable
fun TimetablePage(timetable: Map<String, List<TimeSchedule>>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        timetable.forEach { (day, classList) ->
            item {
                CollectiveListRow(day = day, classList = classList)
            }
        }
    }
}
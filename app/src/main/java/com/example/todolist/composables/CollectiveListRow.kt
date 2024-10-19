package com.example.todolist.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolist.data.TimeSchedule

// Composable function for a single day's schedule
@Composable
fun CollectiveListRow(day: String, classList: List<TimeSchedule>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Day of the week title
        Text(
            text = day,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        // List of classes for the day
        classList.forEach { classSchedule ->
            ListRow(timeSchedule = classSchedule)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
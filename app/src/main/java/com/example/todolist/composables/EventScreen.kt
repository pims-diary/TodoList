package com.example.todolist.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.todolist.data.StudentEvent
import java.time.format.DateTimeFormatter
import java.util.Locale


// Grouping events by month
@RequiresApi(Build.VERSION_CODES.O)
fun getEventsGroupedByMonth(events: List<StudentEvent>): Map<String, List<StudentEvent>> {
    val formatter = DateTimeFormatter.ofPattern("MMMM", Locale.getDefault())
    return events
        .sortedBy { it.date }
        .groupBy { it.date.format(formatter) }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EventsScreen(events: List<StudentEvent>) {
    val eventsByMonth = getEventsGroupedByMonth(events)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Loop through the months and events for each month
        eventsByMonth.forEach { (month, monthEvents) ->
            item {
                Text(
                    text = month,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(monthEvents) { event ->
                EventCard(event)
            }
        }
    }
}
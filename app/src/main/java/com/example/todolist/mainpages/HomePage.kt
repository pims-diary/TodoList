package com.example.todolist.mainpages

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolist.composables.buttons.TileButton
import com.example.todolist.data.AppDatabase

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomePage(db: AppDatabase) {
    val navController = rememberNavController()

    // Navigation within the Home tab
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeLandingScreen(navController) }
        composable("todo") { TodoListPage(db) }
        composable("timetable") { TimetablePage(timetable = timetable) }
        composable("courses") { CoursesPage(navController) }
        composable("dates") { ImportantDatesPage() }
        composable("details") { DetailsScreen(navController = navController) }
        composable("courseDetail/{courseCode}") { backStackEntry ->
            val courseCode = backStackEntry.arguments?.getString("courseCode")
            val course = courses.find { it.code == courseCode }
            course?.let { CourseDetailPage(course = it) }
        }
    }
}

@Composable
fun HomeLandingScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // First row with two TileButtons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TileButton(
                text = "To Do List",
                icon = Icons.Default.List,
                onClick = { navController.navigate("todo") }
            )
            TileButton(
                text = "Timetable",
                icon = Icons.Default.DateRange,
                onClick = { navController.navigate("timetable") }
            )
        }
        Spacer(modifier = Modifier.height(8.dp)) // Space between rows

        // Second row with two TileButtons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TileButton(
                text = "Applied Courses",
                icon = Icons.Default.Create,
                onClick = { navController.navigate("courses") }
            )
            TileButton(
                text = "Important Dates",
                icon = Icons.Default.Notifications,
                onClick = { navController.navigate("dates") }
            )
        }
    }
}

@Composable
fun DetailsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "This is the Details Screen in Home Tab")
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Go back to Home")
        }
    }
}

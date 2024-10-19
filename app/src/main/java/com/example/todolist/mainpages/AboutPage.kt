package com.example.todolist.mainpages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.todolist.R
import com.example.todolist.composables.ButtonToMapsAt
import com.example.todolist.composables.CustomButton
import com.example.todolist.composables.OpenDialer
import com.example.todolist.composables.PhotoCarousel

val imageList = listOf(
    R.drawable.sample_image_1, // Replace with your image resources
    R.drawable.sample_image_2,
    R.drawable.sample_image_3,
    R.drawable.sample_image_4
)

@Composable
fun AboutPage() {
    val navController = rememberNavController()

    // Navigation within the Home tab
    NavHost(navController = navController, startDestination = "about") {
        composable("about") { AboutLandingScreen(navController) }
        composable("photos") { SeeAllPhotos() }
    }
}

@Composable
fun AboutLandingScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth()
            // on below line we are
            // adding padding for our column
            .padding(5.dp),
        // on below line we are specifying horizontal
        // and vertical alignment for our column
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        PhotoCarousel(imageList = imageList)
        CustomButton(text = "See all photos") {
            navController.navigate("photos")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(horizontalAlignment = Alignment.Start) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Call us at: ",
                    modifier = Modifier
                        .width(120.dp)
                        .padding(start = 6.dp)
                )
                OpenDialer(phoneNumber = "+64284307422")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Our location: ",
                    modifier = Modifier
                        .width(120.dp)
                        .padding(start = 6.dp)
                )
                ButtonToMapsAt(
                    latitude = -36.8211,
                    longitude = 174.6123
                )
            }
        }
    }
}
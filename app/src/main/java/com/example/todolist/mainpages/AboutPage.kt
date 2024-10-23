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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolist.R
import com.example.todolist.composables.ButtonToMapsAt
import com.example.todolist.composables.LongPressCopyText
import com.example.todolist.composables.buttons.CustomButton
import com.example.todolist.composables.OpenDialer
import com.example.todolist.composables.OpenEmail
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
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            ContactInfoRow(
                label = "Call us at:",
                icon = Icons.Default.Phone,
                content = { OpenDialer(phoneNumber = "+64284307422") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ContactInfoRow(
                label = "Our location:",
                icon = Icons.Default.LocationOn,
                content = { ButtonToMapsAt(latitude = -36.864, longitude = 174.722) }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ContactInfoRow(
                label = "Our Email:",
                icon = Icons.Default.Email,
                content = { OpenEmail() }
            )

            Spacer(modifier = Modifier.height(32.dp))

            // This is a text composable on long press of which text is copied to clipboard
            LongPressCopyText(
                textToCopy = "28A Linwood Avenue, Mount Albert, Auckland 1025"
            )
        }
    }
}

@Composable
fun ContactInfoRow(
    label: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    content: @Composable () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.Gray
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.width(120.dp)
        )
        content()
    }
}

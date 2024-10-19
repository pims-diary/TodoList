package com.example.todolist.composables

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.ui.constants.TodoInputBarFabColor

@Composable
fun ButtonToMapsAt(latitude: Double, longitude: Double) {
    val context = LocalContext.current
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = TodoInputBarFabColor),
        onClick = {
            val gmmIntentUri = Uri.parse("geo:$latitude,$longitude")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            // Check if Google Maps is installed
            if (mapIntent.resolveActivity(context.packageManager) != null) {
                context.startActivity(mapIntent)
            }
        }
    ) {
        Text(
            "Open in Google Maps",
            modifier = Modifier.padding(10.dp),
            color = Color.White,
            fontSize = 15.sp)
    }
}
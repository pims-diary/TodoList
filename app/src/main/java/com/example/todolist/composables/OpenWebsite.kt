package com.example.todolist.composables

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.ui.constants.TodoThemeColor

@Composable
fun OpenWebsite() {
    val context = LocalContext.current

    Button(
        colors = ButtonDefaults.buttonColors(containerColor = TodoThemeColor),
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.ais.ac.nz/") // Replace with the website you want to open
            }
            context.startActivity(intent)
        }
    ) {
        Text(
            text = "Go to Website",
            modifier = Modifier.padding(10.dp),
            color = Color.White,
            fontSize = 15.sp
        )
    }
}
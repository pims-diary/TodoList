package com.example.todolist.composables

import android.content.Intent
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
import com.example.todolist.ui.constants.TodoThemeColor

@Composable
fun OpenEmail() {
    val context = LocalContext.current

    // Email and subject details
    val recipientEmail = "example@example.com"
    val subject = "This is the subject"

    Button(
        colors = ButtonDefaults.buttonColors(containerColor = TodoThemeColor),
        onClick = {
            // Create an email intent with ACTION_SEND
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "message/rfc822" // Ensure it's an email app
                putExtra(Intent.EXTRA_EMAIL, arrayOf(recipientEmail)) // Recipient's email
                putExtra(Intent.EXTRA_SUBJECT, subject) // Email subject
            }

            // Verify if there's an app to handle the intent
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(Intent.createChooser(intent, "Choose an email client"))
            }
        }
    ) {
        Text(
            text = "Send Email",
            modifier = Modifier.padding(10.dp),
            color = Color.White,
            fontSize = 15.sp
        )
    }
}

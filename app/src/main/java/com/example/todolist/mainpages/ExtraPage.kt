package com.example.todolist.mainpages

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todolist.viewmodels.UserViewModel

@Composable
fun ExtraPage(userViewModel: UserViewModel = viewModel()) {
//    ShowGetCallResponse(userViewModel)
//    KeyEventExample()
//    CopyTextOnLongPressExample()
}

@Composable
fun ShowGetCallResponse(userViewModel: UserViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = {
                // Fetch users when button is clicked
                userViewModel.getUsers()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Fetch Users")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Show error message if there is any
        if (userViewModel.errorMessage.isNotEmpty()) {
            Text(text = userViewModel.errorMessage, color = MaterialTheme.colorScheme.error)
        }

        // Display the list of users
        userViewModel.users.forEach { user ->
            Text(text = "ID: ${user.id}, Name: ${user.name}, Email: ${user.email}")
        }
    }
}

@Composable
fun KeyEventExample() {
    // State to hold the key event information
    var keyEventMessage by remember { mutableStateOf("Press any key...") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Basic TextField with onKeyEvent modifier
        BasicTextField(
            value = keyEventMessage,
            onValueChange = { /* no need to handle text changes in this case */ },
            modifier = Modifier
                .fillMaxWidth()
                .onKeyEvent { keyEvent ->
                    when (keyEvent.type) {
                        KeyEventType.KeyDown -> {
                            keyEventMessage = "Key Down: ${keyEvent.key.keyCode}"
                            true // Consume the event
                        }
                        KeyEventType.KeyUp -> {
                            keyEventMessage = "Key Up: ${keyEvent.key.keyCode}"
                            true // Consume the event
                        }
                        else -> false // Don't consume other events
                    }
                }
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display the key press information
        Text(text = keyEventMessage)
    }
}

@Composable
fun CopyTextOnLongPressExample() {
    // Get the ClipboardManager and context
    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    val context: Context = LocalContext.current

    // The text to be copied
    val textToCopy = "Long press to copy this text"

    // Text composable with long press gesture
    Text(
        text = textToCopy,
        modifier = Modifier
            .padding(16.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        // Copy the text to clipboard
                        clipboardManager.setText(AnnotatedString(textToCopy))

                        // Show a Toast message
                        Toast.makeText(context, "The text is copied to clipboard", Toast.LENGTH_SHORT).show()
                    }
                )
            }
    )
}
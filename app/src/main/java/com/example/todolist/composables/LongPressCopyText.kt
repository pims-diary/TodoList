package com.example.todolist.composables

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp

@Composable
fun LongPressCopyText(textToCopy: String) {
    // Get the ClipboardManager and context
    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    val context: Context = LocalContext.current

    // The text to be copied
    val instructions = "Long press the address to copy it"

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
                        Toast
                            .makeText(
                                context,
                                "The address is copied to clipboard",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                )
            }
    )
    Text(text = instructions)
}
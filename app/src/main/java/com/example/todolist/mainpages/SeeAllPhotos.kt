package com.example.todolist.mainpages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SeeAllPhotos() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        imageList.forEach { image ->
            item {
                ImageItem(imageRes = image)
            }
        }
    }
}

@Composable
fun ImageItem(imageRes: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth() // Fill the full screen width
            .aspectRatio(16f / 9f) // Adjust the aspect ratio as needed
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop, // Ensure the image is cropped to fill the width
            modifier = Modifier.fillMaxSize()
        )
    }
}
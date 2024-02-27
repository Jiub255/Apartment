package com.example.apartment.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun HomeScreen(
    modifier: Modifier = Modifier,
    onBrowseClicked: () -> Unit = {}
) {
    Button(onClick = onBrowseClicked) {
        Text(text = "Browse Items")
    }
}
package com.example.apartment.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    extraSmall = RoundedCornerShape(
        size = 35.dp
    ),
    small = RoundedCornerShape(
        size = 50.dp
    ),
    medium = RoundedCornerShape(
        topStart = 2.dp,
        topEnd = 12.dp,
        bottomStart = 12.dp,
        bottomEnd = 2.dp
    ),
    large = RoundedCornerShape(
        topStart = 4.dp,
        topEnd = 16.dp,
        bottomStart = 16.dp,
        bottomEnd = 4.dp
    ),
    extraLarge = RoundedCornerShape(
        topStart = 6.dp,
        topEnd = 20.dp,
        bottomStart = 20.dp,
        bottomEnd = 6.dp
    )
)

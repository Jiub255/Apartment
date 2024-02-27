package com.example.apartment.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.time.LocalDateTime

data class Item(
    @StringRes val nameRes: Int,
    val price: Float,
    val dateTimeAdded: LocalDateTime,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)

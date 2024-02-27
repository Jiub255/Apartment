package com.example.apartment.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.apartment.R
import com.example.apartment.model.Item
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
val bed_frame = Item(
    nameRes = R.string.item_name_1,
    descriptionRes = R.string.item_desc_1,
    price = 100.00f,
    dateTimeAdded = LocalDateTime.of(
        2024,
        10,
        23,
        8,
        45,
        1
    ),
    imageRes = R.drawable.bed_frame
)
@RequiresApi(Build.VERSION_CODES.O)
val bookshelf = Item(
    nameRes = R.string.item_name_2,
    descriptionRes = R.string.item_desc_2,
    price = 420.69f,
    dateTimeAdded = LocalDateTime.of(
        2024,
        10,
        23,
        5,
        5,
        16
    ),
    imageRes = R.drawable.bookshelf_victorian_mahogany
)
@RequiresApi(Build.VERSION_CODES.O)
val couch = Item(
    nameRes = R.string.item_name_3,
    descriptionRes = R.string.item_desc_3,
    price = 10000.00f,
    dateTimeAdded = LocalDateTime.of(
        2024,
        10,
        21,
        21,
        9,
        55
    ),
    imageRes = R.drawable.couch
)
@RequiresApi(Build.VERSION_CODES.O)
val space_chairs = Item(
    nameRes = R.string.item_name_4,
    descriptionRes = R.string.item_desc_4,
    price = 999.99f,
    dateTimeAdded = LocalDateTime.of(
        2023,
        1,
        26,
        2,
        4,
        0
    ),
    imageRes = R.drawable.space_chairs
)

@RequiresApi(Build.VERSION_CODES.O)
object DataSource {
    val items: MutableList<Item> = mutableListOf(
        bed_frame,
        bookshelf,
        couch,
        space_chairs,
        bed_frame,
        bookshelf,
        couch,
        space_chairs,
        bed_frame,
        bookshelf,
        couch,
        space_chairs,
        bed_frame,
        bookshelf,
        couch,
        space_chairs,
        bed_frame,
        bookshelf,
        couch,
        space_chairs
    )
}
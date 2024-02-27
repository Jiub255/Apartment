package com.example.apartment.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.apartment.R
import com.example.apartment.data.DataSource
import com.example.apartment.model.Item

@Composable
@Preview
@RequiresApi(Build.VERSION_CODES.O)
fun BrowseItemsScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(),
    onBackClicked: () -> Unit = {}
) {
    Column {
        Button(
            onClick = onBackClicked
        ) {
            Text(text = "Back to Home")
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = paddingValues
        ) {
            items(DataSource.items) { item ->
                ItemCard(
                    item = item,
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_medium))
                )
            }
        }
    }
}

@Composable
fun ItemCard(item: Item, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        // TODO: Put this in uiState. Or put in ItemCard parameters?
        //  It's not item data, it's ItemCard data. Where to put it?
        var expanded by remember { mutableStateOf(false) }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .animateContentSize()
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    expanded = !expanded
                }
        ) {

            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                //.size(dimensionResource(id = R.dimen.image_size))
            )
            if (expanded) {
                Text(
                    text = stringResource(id = item.nameRes),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = modifier
                )
                Text(
                    text = "$" + "%.2f".format(item.price),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier
                )
                Text(
                    // TODO: Make "timeAgo" function to find how long ago item was posted. Use hours ago for less than one day, and days ago otherwise.
                    //  Or, use the largest unit that there's at least one of. Starting with seconds, up to months? years?
                    //text = "Added timeAgo(item.dateTimeAdded) ago"
                    text = "Added TODO days ago",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = modifier
                )
                Text(
                    text = stringResource(id = item.descriptionRes),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier
                )
            }
        }
    }
}
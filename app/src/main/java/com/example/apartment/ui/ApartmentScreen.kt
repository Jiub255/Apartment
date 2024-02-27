package com.example.apartment.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.apartment.R
import com.example.apartment.ui.theme.ApartmentTheme

enum class ApartmentScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    Browse(title = R.string.browse_items)
}

// TODO: Find all data and logic to separate out into ViewModel and UiState (and DataSource).

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ApartmentAppBar(
    currentScreen: ApartmentScreen,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.icon_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
                Text(
                    text = stringResource(id = currentScreen.title),
                    style = MaterialTheme.typography.displaySmall
                )
            }
        },
        modifier = modifier
    )
}

@Composable
@RequiresApi(Build.VERSION_CODES.O)
fun ApartmentApp(
    modifier: Modifier = Modifier,
    // TODO: Not really sure what I'm doing here with the viewModel yet.
    //  Put it here or where? How to keep track of expanded bool for each item?
    appViewModel: AppViewModel =  viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = ApartmentScreen.valueOf(
        backStackEntry?.destination?.route ?: ApartmentScreen.Home.name
    )
    Scaffold(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_large)),
        topBar = {
            ApartmentAppBar(currentScreen = currentScreen)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = ApartmentScreen.Home.name,
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            composable(route = ApartmentScreen.Home.name) {
                HomeScreen(
                    onBrowseClicked = { navController.navigate(ApartmentScreen.Browse.name) }
                )
            }
            composable(route = ApartmentScreen.Browse.name) {
                BrowseItemsScreen(
                    paddingValues = paddingValues,
                    onBackClicked = { navController.navigate(ApartmentScreen.Home.name) }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
@RequiresApi(Build.VERSION_CODES.O)
fun GreetingPreview() {
    ApartmentTheme {
        ApartmentApp()
    }
}
package com.example.tableforyou.Elements

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.tableforyou.Navigation.AppDestination
import com.example.tableforyou.Navigation.Favorite
import com.example.tableforyou.Navigation.Home
import com.example.tableforyou.Navigation.Reservations
import com.example.tableforyou.Navigation.Settings


@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier, onTabSelected: (AppDestination) -> Unit, currentScreen: AppDestination){
    NavigationBar {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Rounded.Home,
                    contentDescription = null
                )
            },
            label = {
                Text("Home")

            },
            selected = false ,
            onClick = { onTabSelected(Home) },

            )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Rounded.Favorite,
                    contentDescription = null
                )
            },
            label = {
                Text("Favorite")

            },
            selected = false ,
            onClick = { onTabSelected(Favorite)},
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Rounded.DateRange,
                    contentDescription = null
                )
            },
            label = {
                Text("Reservations")

            },
            selected = false ,
            onClick = { onTabSelected(Reservations) },
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Rounded.Settings,
                    contentDescription = null
                )
            },
            label = {
                Text("Settings")

            },
            selected = false ,
            onClick = { onTabSelected(Settings) },
        )

    }
}
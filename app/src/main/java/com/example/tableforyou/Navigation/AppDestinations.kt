package com.example.tableforyou.Navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface AppDestination {
    //val icon: ImageVector
    val route: String
    //val screen: @Composable () -> Unit
}

object Home : AppDestination {
    //override val icon = Icons.Filled.PieChart
    override val route = "Home"
    //override val screen: @Composable () -> Unit = { HomeScreen() }
}

object WriteReviewPage : AppDestination {
    //override val icon = Icons.Filled.PieChart
    override val route = "WriteReviewPage"
    //override val screen: @Composable () -> Unit = { HomeScreen() }
    val wrp_idArg = "wrp_id"
    val routeWithArgs = "${WriteReviewPage.route}/{${WriteReviewPage.wrp_idArg}}"
    val arguments = listOf(
        navArgument(WriteReviewPage.wrp_idArg) { type = NavType.StringType }
    )
}

object RestorantPage : AppDestination {
    //override val icon = Icons.Filled.PieChart
    override val route = "RestorantPage"
    //override val screen: @Composable () -> Unit = { RestorantPageScreen() }
    val restorant_idArg = "restorant_id"
    val routeWithArgs = "${route}/{${restorant_idArg}}"
    val arguments = listOf(
        navArgument(restorant_idArg) { type = NavType.StringType }
    )
}

object Settings : AppDestination {
    //override val icon = Icons.Filled.PieChart
    override val route = "Settings"
    //override val screen: @Composable () -> Unit = { SettingsScreen() }
}

object Favorite : AppDestination {
    //override val icon = Icons.Filled.PieChart
    override val route = "Favorite"
    //override val screen: @Composable () -> Unit = { FavoriteScreen() }
}

object Reservations : AppDestination {
    //override val icon = Icons.Filled.PieChart
    override val route = "Reservations"
    //override val screen: @Composable () -> Unit = { TODO() }
}

object LogIn : AppDestination {
    //override val icon = Icons.Filled.PieChart
    override val route = "LogIn"
    //override val screen: @Composable () -> Unit = { SettingsScreen() }
}

object Null : AppDestination {
    //override val icon = Icons.Filled.PieChart
    override val route = "Null"
    //override val screen: @Composable () -> Unit = { SettingsScreen() }
}

object CreateAccount : AppDestination {
    //override val icon = Icons.Filled.PieChart
    override val route = "CreateAccount"
    //override val screen: @Composable () -> Unit = { SettingsScreen() }
}

val BottomNavigationBarScreens = listOf(Home, Favorite, Reservations, Settings)
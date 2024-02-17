package com.example.tableforyou.Navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tableforyou.Authentication.CreateAccountForm
import com.example.tableforyou.Authentication.LoginForm
import com.example.tableforyou.Data.Restorant
import com.example.tableforyou.Data.Table
import com.example.tableforyou.Elements.AboutUsPage
import com.example.tableforyou.Elements.ProfilePage
import com.example.tableforyou.Pages.FavoriteScreen
import com.example.tableforyou.Pages.HomeScreen
import com.example.tableforyou.Pages.ReservationsScreen
import com.example.tableforyou.Pages.RestorantPageScreen
import com.example.tableforyou.Pages.SettingsScreen
import com.example.tableforyou.Pages.WriteReviewPage

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    openCamera: () -> Unit,
    signIn: () -> Unit,
    GsignIn: () -> Unit,
    createAccount: () -> Unit,
    signOut: ()-> Unit,
    SignOUT: ()->Unit,
    addImage:()->Unit,
    addToFavorite: (Restorant)-> Unit,
    removeFromFavorite: (Restorant) -> Unit,
    confirmReservation: (Table, String) -> Unit,
    UpReviewImg: (Uri)-> Unit,

){

    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier
    ) {
        composable(route = Home.route) {
            HomeScreen(
                //onClickOpenRestorant = {navController.navigateSingleTopTo(RestorantPage.route)}
                onClickOpenRestorant = { restorantId ->
                    //Log.v("prova", "restorantid"+restorantId)
                    navController.navigateToSingleRestorant(restorantId)},
                addToFavorite = addToFavorite,
                removeFromFavorite = removeFromFavorite
            )
        }/*
        composable(route = WriteReviewPage.route) {
            var getRes by remember { mutableStateOf(RestorantList.list[0]) }
            WriteReviewPage(
                onBackClickedRev = { restorantId ->
                    getRes = RestorantList.getRestorant(restorantId)
                    //Log.v("prova", "restorantid = "+getRes)
                    navController.navigateToSingleRestorant(restorantId)
                    },
                restorant = getRes
            )
        }*/
        composable(
            route = WriteReviewPage.routeWithArgs,
            arguments = WriteReviewPage.arguments
        ) {
                navBackStackEntry ->
            // Retrieve the passed argument
            val wrp_restorantId =
                navBackStackEntry.arguments?.getString(WriteReviewPage.wrp_idArg)

            // Pass accountType to SingleAccountScreen
            //RestorantPageScreen(restorantId)
            WriteReviewPage(
                wrpId =  wrp_restorantId,
                onBackClickedRev =  {restorantId ->
            //Log.v("prova", "restorantid"+restorantId)
            navController.navigateToSingleRestorant(restorantId)},
                //restorant = RestorantList.getRestorant(wrp_restorantId)
                openCamera = openCamera,
                addImage = addImage,
                UpReviewImg = UpReviewImg



            )
        }

        composable(
            route = RestorantPage.routeWithArgs,
            arguments = RestorantPage.arguments
        ) {
                navBackStackEntry ->
            // Retrieve the passed argument
            val restorantId =
                navBackStackEntry.arguments?.getString(RestorantPage.restorant_idArg)

            // Pass accountType to SingleAccountScreen
            //RestorantPageScreen(restorantId)
            RestorantPageScreen(
                restorantId = restorantId,
                onBackClicked =  {newScreen ->
            navController.navigateSingleTopTo(newScreen.route)},
                /*onButtonClicked = {newScreen ->
                    navController.navigateSingleTopTo(newScreen.route)},*/
                onButtonClicked = {wrp_id ->
                    navController.navigateToSingleRestorantWriteReview(wrp_id)},
                openCamera = openCamera,
                addToFavorite = addToFavorite,
                removeFromFavorite = removeFromFavorite,
                confirmReservation = confirmReservation
                )
        }
        composable(route = Reservations.route) {
            ReservationsScreen()
        }
        composable(route = Favorite.route) {
            FavoriteScreen(onClickOpenRestorant = { restorantId ->
                //Log.v("prova", "restorantid"+restorantId)
                navController.navigateToSingleRestorant(restorantId)},
                addToFavorite = addToFavorite,
                removeFromFavorite = removeFromFavorite)
        }

        composable(route = Settings.route) {
            SettingsScreen(
                signOut= signOut,
                SignOUT = SignOUT,
                gotoAboutUs ={newScreen ->
                    navController.navigateSingleTopTo(newScreen.route)},
                gotoProfile ={newScreen ->
                    navController.navigateSingleTopTo(newScreen.route)},
            )
        }

        composable(route = Null.route) {

        }
        composable(route = AboutUs.route) {
            AboutUsPage(onBackClicked = {newScreen ->
                navController.navigateSingleTopTo(newScreen.route)}
            )
        }
        composable(route = Profile.route) {
            ProfilePage(onBackClicked = {newScreen ->
                navController.navigateSingleTopTo(newScreen.route)}
            )
        }

        composable(route = LogIn.route) {
            LoginForm(
                signIn= signIn,
                GsignIn = GsignIn,
                goToCreateAccount ={newScreen ->
                    navController.navigateSingleTopTo(newScreen.route)} )
        }

        composable(route = CreateAccount.route) {
            CreateAccountForm(
                createAccount,
                onBackClicked ={newScreen ->
                navController.navigateSingleTopTo(newScreen.route)},
                pickPhoto = {})
        }

    }
}
@Composable
fun AppNavHost2(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    openCamera: () -> Unit,
    signIn: () -> Unit,
    GsignIn: () -> Unit,
    createAccount: () ->Unit,
    SignOUT: ()->Unit,
    pickPhoto:()->Unit,
    addToFavorite: (Restorant)-> Unit,
    removeFromFavorite: (Restorant) -> Unit,
    confirmReservation: (Table,String) -> Unit
){

    NavHost(
        navController = navController,
        startDestination = LogIn.route,
        modifier = modifier
    ) {
        composable(route = Home.route) {
            HomeScreen(
                //onClickOpenRestorant = {navController.navigateSingleTopTo(RestorantPage.route)}
                onClickOpenRestorant = { restorantId ->
                    //Log.v("prova", "restorantid"+restorantId)
                    navController.navigateToSingleRestorant(restorantId)},
                addToFavorite = addToFavorite,
                removeFromFavorite = removeFromFavorite
            )
        }/*
        composable(route = WriteReviewPage.route) {
            var getRes by remember { mutableStateOf(RestorantList.list[0]) }
            WriteReviewPage(
                onBackClickedRev = { restorantId ->
                    getRes = RestorantList.getRestorant(restorantId)
                    //Log.v("prova", "restorantid = "+getRes)
                    navController.navigateToSingleRestorant(restorantId)
                    },
                restorant = getRes
            )
        }*/
        composable(
            route = WriteReviewPage.routeWithArgs,
            arguments = WriteReviewPage.arguments
        ) {
                navBackStackEntry ->
            // Retrieve the passed argument
            val wrp_restorantId =
                navBackStackEntry.arguments?.getString(WriteReviewPage.wrp_idArg)

            // Pass accountType to SingleAccountScreen
            //RestorantPageScreen(restorantId)
            WriteReviewPage(
                wrpId =  wrp_restorantId,
                onBackClickedRev =  {restorantId ->
                    //Log.v("prova", "restorantid"+restorantId)
                    navController.navigateToSingleRestorant(restorantId)},
                //restorant = RestorantList.getRestorant(wrp_restorantId)
                openCamera = openCamera,
                addImage={},
                UpReviewImg = {}



                )
        }

        composable(
            route = RestorantPage.routeWithArgs,
            arguments = RestorantPage.arguments
        ) {
                navBackStackEntry ->
            // Retrieve the passed argument
            val restorantId =
                navBackStackEntry.arguments?.getString(RestorantPage.restorant_idArg)

            // Pass accountType to SingleAccountScreen
            //RestorantPageScreen(restorantId)
            RestorantPageScreen(
                restorantId = restorantId,
                onBackClicked =  {newScreen ->
                    navController.navigateSingleTopTo(newScreen.route)},
                /*onButtonClicked = {newScreen ->
                    navController.navigateSingleTopTo(newScreen.route)},*/
                onButtonClicked = {wrp_id ->
                    navController.navigateToSingleRestorantWriteReview(wrp_id)},
                openCamera = openCamera,
                addToFavorite = addToFavorite,
                removeFromFavorite = removeFromFavorite,
                confirmReservation = confirmReservation

            )
        }
        composable(route = Reservations.route) {
            ReservationsScreen()
        }
        composable(route = Favorite.route) {
            FavoriteScreen(onClickOpenRestorant = { restorantId ->
                //Log.v("prova", "restorantid"+restorantId)
                navController.navigateToSingleRestorant(restorantId)},
                addToFavorite = addToFavorite,
                removeFromFavorite = removeFromFavorite)
        }

        composable(route = Settings.route) {
            SettingsScreen(
                signOut= SignOUT ,
                SignOUT = SignOUT,
                gotoAboutUs = {},
                gotoProfile = {}
            )
        }

        composable(route = Null.route) {

        }
        composable(route = AboutUs.route) {
            AboutUsPage(onBackClicked = {newScreen ->
                navController.navigateSingleTopTo(newScreen.route)}
            )
        }
        composable(route = Profile.route) {
            AboutUsPage(onBackClicked = {newScreen ->
                navController.navigateSingleTopTo(newScreen.route)}
            )
        }

        composable(route = LogIn.route) {
            LoginForm(
                signIn= signIn,
                GsignIn = GsignIn,
                goToCreateAccount ={newScreen ->
                    navController.navigateSingleTopTo(newScreen.route)} )
        }

        composable(route = CreateAccount.route) {
            CreateAccountForm(
                createAccount = createAccount,
                onBackClicked ={newScreen ->
                navController.navigateSingleTopTo(newScreen.route)},
                pickPhoto = pickPhoto)
        }

    }
}
private fun NavHostController.navigateToSingleRestorant(restorantId: String) {
    this.navigateSingleTopTo("${RestorantPage.route}/$restorantId")
}

private fun NavHostController.navigateToSingleRestorantWriteReview(wrpId: String) {
    this.navigateSingleTopTo("${WriteReviewPage.route}/$wrpId")
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = false
        }
        launchSingleTop = true
        restoreState = true
    }
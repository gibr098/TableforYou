package com.example.tableforyou.Pages

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.tableforyou.Data.FavoriteList
import com.example.tableforyou.Elements.SearchBar
import com.example.tableforyou.Elements.UpBar
import com.example.tableforyou.Navigation.Home

@Composable
fun FavoriteScreen(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    Column(){
        UpBar("Favorites", false, onBackClicked = { }, Home)
        SearchBar()
        RestorantCardFavoriteColumn()

    }
}

@Composable
fun RestorantCardFavoriteColumn(modifier: Modifier = Modifier) {
    //Restorants(Users.list[0].preferred)
    Restorants(FavoriteList.list)

}


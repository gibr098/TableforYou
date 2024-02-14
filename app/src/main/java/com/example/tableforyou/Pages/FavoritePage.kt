package com.example.tableforyou.Pages

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.tableforyou.Data.PREFERITIUTENTE
import com.example.tableforyou.Data.Restorant
import com.example.tableforyou.Elements.SearchBar
import com.example.tableforyou.Elements.UpBar
import com.example.tableforyou.Navigation.Home

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    onClickOpenRestorant: (String)-> Unit,
    addToFavorite: (Restorant)-> Unit,
    removeFromFavorite: (Restorant) -> Unit
    ){
    val navController = rememberNavController()
    Column(){
        UpBar("Favorites", false, onBackClicked = { }, Home)
        SearchBar()
        RestorantCardFavoriteColumn(modifier,onClickOpenRestorant,addToFavorite,removeFromFavorite)

    }
}

@Composable
fun RestorantCardFavoriteColumn(
    modifier: Modifier = Modifier,
    onClickOpenRestorant: (String)-> Unit,
    addToFavorite: (Restorant)-> Unit,
    removeFromFavorite: (Restorant) -> Unit
    ) {
    //Restorants(Users.list[0].preferred)
    Restorants(
        PREFERITIUTENTE,
        onClickOpenRestorant = onClickOpenRestorant,
        addToFavorite = addToFavorite,
        removeFromFavorite = removeFromFavorite,
        )

}


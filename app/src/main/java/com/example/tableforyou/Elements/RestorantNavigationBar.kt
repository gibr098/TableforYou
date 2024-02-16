package com.example.tableforyou.Elements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun RestorantNavigationBar(
    modifier: Modifier = Modifier,
    menu: () -> Unit,
    reserve: () -> Unit,
    review: () -> Unit
){
    NavigationBar(
        modifier = Modifier.height(50.dp)
    ) {
        NavigationBarItem(
            icon = {
                Row() {
                    Text("Menu")
                    //Icons.Rounded.ArrowDropDown
                }
            },

            //label = { },
            selected = false ,
            onClick =  menu ,
        )
        NavigationBarItem(
            icon = {
                Row() {
                    Text("Reserve Table")
                    //Icons.Rounded.ArrowDropDown
                }
            },

            //label = { },
            selected = false ,
            onClick = reserve,
        )
        NavigationBarItem(
            icon = {
                Row() {
                    Text("Reviews")
                    //Icons.Rounded.ArrowDropDown
                }
            },

            //label = { },
            selected = false ,
            onClick = review,
        )
    }
}
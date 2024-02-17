package com.example.tableforyou.Elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tableforyou.Data.UTENTIDADB
import com.example.tableforyou.Navigation.AppDestination
import com.example.tableforyou.Navigation.Settings


@Composable
fun ProfilePage(
    onBackClicked: (AppDestination)-> Unit
){
    UpBar(titolo = "Profile", back = true, onBackClicked = onBackClicked , dest = Settings )
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 80.dp)
    ){
        AsyncImage(model = UTENTIDADB.profile_img , contentDescription = "profile img")
        Spacer(modifier = Modifier.padding(all = 10.dp))
        Text(UTENTIDADB.name, fontSize = 35.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.padding(all=5.dp))
        Text(UTENTIDADB.mail, fontSize = 25.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.padding(all=40.dp))
        Text("TableforYou", fontSize = 21.sp)
        Text("Application", fontSize = 21.sp)


    }
}
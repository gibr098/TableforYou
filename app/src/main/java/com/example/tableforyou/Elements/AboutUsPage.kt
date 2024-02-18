package com.example.tableforyou.Elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tableforyou.Navigation.AppDestination
import com.example.tableforyou.Navigation.Settings
import com.example.tableforyou.R


@Composable
fun AboutUsPage(
    onBackClicked: (AppDestination)-> Unit
){
    UpBar(titolo = "About Us", back = true, onBackClicked = onBackClicked , dest = Settings )
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 50.dp)
    ){
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "icon")
        Spacer(modifier = Modifier.padding(all = 10.dp))
        Text("Exam Project of", fontSize = 25.sp, textAlign = TextAlign.Center)
        Text("Mobile Application", fontSize = 25.sp, textAlign = TextAlign.Center)
        Text("and", fontSize = 25.sp, textAlign = TextAlign.Center)
        Text("Cloud Computing", fontSize = 25.sp, textAlign = TextAlign.Center)
        Text("Course Year 2024", fontSize = 25.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.padding(all=10.dp))
        Text("Project developed by:", fontSize = 21.sp)
        Text("Sirico Giuseppe Gabriele", fontSize = 21.sp)
        Text("matricola 1810153", fontSize = 21.sp)

    }
}
package com.example.tableforyou.Elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tableforyou.Data.Restorant
import com.example.tableforyou.Navigation.AppDestination


@Composable
fun UpBar(
    titolo: String,
    back: Boolean,
    onBackClicked: (AppDestination) -> Unit,
    dest : AppDestination){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = titolo,
            fontSize = 20.sp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            //horizontalArrangement = Arrangement.SpaceBetween

        ) {
            if(back) {
                Button(
                    onClick = {onBackClicked(dest)},
                    contentPadding = PaddingValues(all = 1.dp),
                    //modifier = Modifier.size(27.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                )
                {
                    Icon(
                        Icons.Rounded.ArrowBack,
                        contentDescription = "goback",

                        )


                }
            }
        }
    }
}

@Composable
fun UpBarRev(
    titolo: String,
    back: Boolean,
    onBackClickedRev: (String) -> Unit = {},
    restorant: Restorant
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = titolo,
            fontSize = 20.sp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            //horizontalArrangement = Arrangement.SpaceBetween

        ) {
            if(back) {
                Button(
                    onClick = {onBackClickedRev(restorant.name)},
                    contentPadding = PaddingValues(all = 1.dp),
                    //modifier = Modifier.size(27.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                )
                {
                    Icon(
                        Icons.Rounded.ArrowBack,
                        contentDescription = "goback",

                        )


                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    //UpBar("Settings", true)
}

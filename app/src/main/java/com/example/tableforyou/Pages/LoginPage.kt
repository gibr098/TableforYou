package com.example.tableforyou.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tableforyou.R


@Preview(showBackground = true)
@Composable
fun LoginPage(){
    Column (
        modifier = Modifier.fillMaxSize(),
        //verticalArrangement = Arrangement.SpaceAround
    ){

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.muzon),
                //painter = painterResource(res.logo),
                contentDescription = "App logo",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(100.dp)
                    // Clip image to be shaped as a circle
                    .clip(RoundedCornerShape(20.dp))
                    .border(
                        1.5.dp,
                        MaterialTheme.colorScheme.primary,
                        RoundedCornerShape(20.dp)
                    )
            )
        }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Username", fontSize = 30.sp)
                Text("Password", fontSize = 30.sp)
                Row {
                    Button(onClick = { /*TODO*/ }) {
                        Text("Log In")

                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text("Exit")

                    }

                }


            }

    }


}

package com.example.tableforyou.Pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tableforyou.Elements.UpBar
import com.example.tableforyou.Navigation.Home
import com.example.tableforyou.R

@Composable
fun SettingsScreen(){
    Settings()
}

@Preview(showBackground = true)
@Composable
fun Settings(){
        Column(modifier = Modifier.fillMaxSize()) {
            UpBar("Settings", false, onBackClicked = { }, Home)
            Row(modifier = Modifier.padding(all = 30.dp)) {
                Image(
                    painter = painterResource(R.drawable.muzon),
                    contentDescription = "Contact profile picture",
                    modifier = Modifier
                        // Set image size to 40 dp
                        .size(100.dp)
                        // Clip image to be shaped as a circle
                        .clip(CircleShape)
                        .border(
                            1.5.dp,
                            MaterialTheme.colorScheme.primary,
                            CircleShape
                        )
                )
                Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                    Text("Nome", fontSize = 25.sp)
                    Text("Cognome", fontSize = 25.sp)

                }

            }
            Spacer(modifier = Modifier.padding(30.dp))
            Column() {
                Button(
                    onClick = { /*TODO*/ },
                    shape = RectangleShape,
                    modifier = Modifier.fillMaxWidth(),
                    border = BorderStroke(width = 1.dp, color = Color.Black),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black,
                    )

                ) {
                    Text(text = "Profile", fontSize = 20.sp)
                }
                Button(
                    onClick = { /*TODO*/ },
                    shape = RectangleShape,
                    modifier = Modifier.fillMaxWidth(),
                    border = BorderStroke(width = 1.dp, color = Color.Black),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black,
                    )

                ) {
                    Text(text = "App Settings", fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.padding(20.dp))
                Button(
                    onClick = { /*TODO*/ },
                    shape = RectangleShape,
                    modifier = Modifier.fillMaxWidth(),
                    border = BorderStroke(width = 1.dp, color = Color.Black),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black,
                    )

                ) {
                    Text(text = "About Us", fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.padding(20.dp))
                Button(
                    onClick = { /*TODO*/ },
                    shape = RectangleShape,
                    modifier = Modifier.fillMaxWidth(),
                    border = BorderStroke(width = 1.dp, color = Color.Black),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black,
                    )

                ) {
                    Text(text = "Log-out", fontSize = 20.sp)
                }


            }
        }

}


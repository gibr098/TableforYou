package com.example.tableforyou.Pages

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tableforyou.Data.UTENTIDADB
import com.example.tableforyou.Elements.UpBar
import com.example.tableforyou.Navigation.Home

@Composable
fun SettingsScreen(signOut:() -> Unit, SignOUT: ()->Unit){
    Settings(signOut, SignOUT)
}


@Composable
fun Settings(
    signOut:() -> Unit,
    SignOUT: ()->Unit
){
        Column(modifier = Modifier.fillMaxSize()) {
            UpBar("Settings", false, onBackClicked = { }, Home)
            Row(modifier = Modifier.padding(all = 30.dp)) {
                /*Image(
                    painter = rememberAsyncImagePainter(Uri.parse(UTENTIDADB.profile_img)),
                    /*
                    painter = if (EmailPasswordActivity().getUserImg()!=null){
                        rememberAsyncImagePainter(EmailPasswordActivity().getUserImg())
                    } else {painterResource(id = R.drawable.defaultimg)},*/
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
                )*/
                AsyncImage(
                    //model = "https://firebasestorage.googleapis.com/v0/b/tableforyou-f235e.appspot.com/o/stregatto.png?alt=media&token=b386cef3-2cfc-4728-a5fd-49bcada70723",
                    model = UTENTIDADB.profile_img,
                    contentDescription = "Translated description of what the image contains",
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
                    Text(UTENTIDADB.name, fontSize = 25.sp)
                    Text(UTENTIDADB.mail, fontSize = 15.sp)
                    //Text(EmailPasswordActivity().getName(), fontSize = 25.sp)
                    //Text(EmailPasswordActivity().getMail(), fontSize = 15.sp)

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
                    onClick = signOut ,
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


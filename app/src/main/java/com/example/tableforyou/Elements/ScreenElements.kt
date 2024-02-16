package com.example.tableforyou.Elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tableforyou.Data.Restorant
import com.example.tableforyou.Data.Review


@Composable
fun BackButton() {
    Button(
        onClick = {  },
        shape = CircleShape,
        modifier = Modifier
            .size(60.dp)


        ,
        contentPadding = PaddingValues(all = 7.dp),
        elevation = ButtonDefaults.buttonElevation(),
        enabled = true,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Gray,
            contentColor = Color.White,
            //disabledContainerColor = Color.Red ,
            //disabledContentColor = Color.White
        )

    ) {
        Icon(
            Icons.Rounded.ArrowBack, //Icons.Rounded.FavoriteBorder,
            contentDescription = null,
            //tint = Color.Red,
            modifier = Modifier.fillMaxSize()

        )
    }
}
@Composable
fun StatelessCounter(press: Boolean, onAdd: ()-> Unit){
    Row {
        Button(
            onClick = onAdd,
            modifier = Modifier.size(20.dp),
            shape = RectangleShape,
            contentPadding = PaddingValues(0.dp),
            enabled = press
        ){

        }
    }
}


@Composable
fun StatefulCounter(
    res: Restorant,
    addToFavorite: (Restorant)-> Unit,
    removeFromFavorite: (Restorant) -> Unit
) {
    var press by rememberSaveable { mutableStateOf(false) }
    //StatelessCounter(press, { press = !press })
    FavoriteButton(res = res, addToFavorite = addToFavorite, removeFromFavorite = removeFromFavorite, pressed = press)
}

@Composable
fun FavoriteButton(
    res: Restorant,
    pressed: Boolean,
    addToFavorite: (Restorant)-> Unit,
    removeFromFavorite: (Restorant) -> Unit
) {
    Spacer(modifier = Modifier.width(170.dp)) //questo è temporaneo
    // probabilmente va modificato
    //var pressed by  remember{ mutableStateOf(true) }



    //var pressed by rememberSaveable {mutableStateOf(UTENTIDADB.preferred.contains(res))}
    //var pressed by rememberSaveable { mutableStateOf(false) }
    var contentcol by remember{ mutableStateOf(Color.LightGray) }
    Button(
        onClick =  {
            //pressed = !pressed
            //addToFavorite(res)
            if(!pressed){
                contentcol = Color.Red
                addToFavorite(res)
                //pressed = !pressed


            }else{
                contentcol = Color.LightGray
                removeFromFavorite(res)
                //pressed = !pressed

            }


                   } ,
        shape = CircleShape,
        modifier = Modifier
            .size(60.dp)
            .padding(all = 10.dp)
            .clickable { }


        ,
        contentPadding = PaddingValues(all = 5.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation =  25.dp, pressedElevation = 25.dp),
        //enabled = pressed,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = contentcol //Color.LightGray,
            //disabledContainerColor = Color.White ,
            //disabledContentColor = Color.Red
        )

    ) {
        Icon(
            Icons.Rounded.Favorite, //Icons.Rounded.FavoriteBorder,
            contentDescription = null,
            //tint = Color.Red,
            modifier = Modifier.fillMaxSize()

        )
    }
}

@Composable
fun ActivateButton(
    openCamera: () -> Unit
) {
    Spacer(modifier = Modifier.width(170.dp)) //questo è temporaneo
    // probabilmente va modificato
    Button(
        onClick = openCamera ,
        shape = RectangleShape,
        modifier = Modifier
            .fillMaxWidth()
        ,
        contentPadding = PaddingValues(all = 7.dp),
        elevation = ButtonDefaults.buttonElevation(),
        //enabled = false,
    ){
        Text(
            "Review",
            textAlign = TextAlign.Center
            )
    }
}

@Composable
fun ReviewButton(
    onButtonClicked: (String) -> Unit={},
    restorant: Restorant
) {
    Spacer(modifier = Modifier.width(170.dp)) //questo è temporaneo
    // probabilmente va modificato
    Button(
        onClick = {onButtonClicked(restorant.name)} ,
        shape = RectangleShape,
        modifier = Modifier
            .size(width = 100.dp, height = 50.dp)
        ,
        contentPadding = PaddingValues(all = 7.dp),
        elevation = ButtonDefaults.buttonElevation(),
        //enabled = false,
    ){
        Text(
            "Review",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ReviewStars(review: Review){
    Row {
        for (i in 1..review.vote)
            Icon(
                Icons.Rounded.Star,
                contentDescription = null,
                tint = Color(0xFFD96600)
            )
        for (i in 1..5-review.vote)
            Icon(
                Icons.Rounded.Star,
                contentDescription = null,
                tint = Color.LightGray
            )
    }
}


@Preview
@Composable
fun ReviewStarsClickable():Int{
    var c1  by remember { mutableStateOf(false) }
    var c2  by remember { mutableStateOf(false) }
    var c3  by remember { mutableStateOf(false) }
    var c4  by remember { mutableStateOf(false) }
    var c5  by remember { mutableStateOf(false) }
    var starVote  by remember { mutableStateOf(0) }



    Spacer(modifier = Modifier.padding(20.dp))
    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Icon(
                Icons.Rounded.Star,
                contentDescription = "1",
                tint = if(c1){Color(0xFFD96600)}else{Color.LightGray},
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        c1 = true; c2 = false; c3 = false; c4 = false; c5 = false; starVote = 1
                    }
            )
        Icon(
            Icons.Rounded.Star,
            contentDescription = "2",
            tint = if(c2){Color(0xFFD96600)}else{Color.LightGray},
            modifier = Modifier
                .size(50.dp)
                .clickable {
                    c1 = true; c2 = true; c3 = false; c4 = false; c5 = false; starVote = 2
                }
        )
        Icon(
            Icons.Rounded.Star,
            contentDescription = "3",
            tint = if(c3){Color(0xFFD96600)}else{Color.LightGray},
            modifier = Modifier
                .size(50.dp)
                .clickable { c1 = true; c2 = true; c3 = true; c4 = false; c5 = false; starVote = 3 }
        )
        Icon(
            Icons.Rounded.Star,
            contentDescription = "4",
            tint = if(c4){Color(0xFFD96600)}else{Color.LightGray},
            modifier = Modifier
                .size(50.dp)
                .clickable { c1 = true; c2 = true; c3 = true; c4 = true; c5 = false; starVote = 4 }
        )
        Icon(
            Icons.Rounded.Star,
            contentDescription = "5",
            tint = if(c5){Color(0xFFD96600)}else{Color.LightGray},
            modifier = Modifier
                .size(50.dp)
                .clickable { c1 = true; c2 = true; c3 = true; c4 = true; c5 = true; starVote = 5 }
        )
    }
    return starVote

}

@Composable
fun RestorantRankStars(restorant: Restorant){

    Row {
        for (i in 1..restorant.rank)
            Icon(
                Icons.Rounded.Star,
                contentDescription = null,
                tint = Color(0xFFD96600)
            )
        for (i in 1..5-restorant.rank)
            Icon(
                Icons.Rounded.Star,
                contentDescription = null,
                tint = Color.LightGray
            )
    }

}

@Composable
fun FavoriteButtonOK() {
    Spacer(modifier = Modifier.width(170.dp)) //questo è temporaneo
    Button(
        onClick =  { } ,
        shape = CircleShape,
        modifier = Modifier
            .size(60.dp)
            .padding(all = 10.dp)
            .clickable { },
        contentPadding = PaddingValues(all = 5.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation =  25.dp, pressedElevation = 25.dp),
        enabled = false,
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = Color.White ,
            disabledContentColor = Color.Red
        )
    ) {
        Icon(
            Icons.Rounded.Favorite, //Icons.Rounded.FavoriteBorder,
            contentDescription = null,
            //tint = Color.Red,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun FavoriteButtonNO() {
    Spacer(modifier = Modifier.width(170.dp)) //questo è temporaneo
    Button(
        onClick =  { } ,
        shape = CircleShape,
        modifier = Modifier
            .size(60.dp)
            .padding(all = 10.dp)
            .clickable { },
        contentPadding = PaddingValues(all = 5.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation =  25.dp, pressedElevation = 25.dp),
        enabled = false,
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = Color.White ,
            disabledContentColor = Color.LightGray
        )
    ) {
        Icon(
            Icons.Rounded.Favorite, //Icons.Rounded.FavoriteBorder,
            contentDescription = null,
            //tint = Color.Red,
            modifier = Modifier.fillMaxSize()
        )
    }
}


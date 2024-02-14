package com.example.tableforyou.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tableforyou.Data.Plate
import com.example.tableforyou.Data.RISTORANTI
import com.example.tableforyou.Data.RISTORANTI.RISTORANTIDADB
import com.example.tableforyou.Data.Restorant
import com.example.tableforyou.Elements.FavoriteButton
import com.example.tableforyou.Elements.ReservationScreen
import com.example.tableforyou.Elements.RestorantNavigationBar
import com.example.tableforyou.Elements.RestorantRankStars
import com.example.tableforyou.Elements.ReviewButton
import com.example.tableforyou.Elements.ReviewColumn
import com.example.tableforyou.Elements.UpBar
import com.example.tableforyou.Navigation.AppDestination
import com.example.tableforyou.Navigation.Home
import com.example.tableforyou.ui.theme.TableforYouTheme


@Composable
fun RestorantPageScreen(
    modifier: Modifier = Modifier,
    restorantId: String? = RISTORANTIDADB[0].name,//RestorantList.list.first().name,
    onBackClicked: (AppDestination) -> Unit,
    onButtonClicked: (String) -> Unit = {},
    openCamera: () -> Unit,
    addToFavorite: (Restorant)-> Unit,
    removeFromFavorite: (Restorant) -> Unit
){

    //val restorant = remember(restorantId) { RestorantList.getRestorant(restorantId) }
    val restorant = remember(restorantId) { RISTORANTI.getRes(restorantId) }
    Column {
        UpBar(titolo = "", true, onBackClicked = onBackClicked, Home)
        RestorantScreen(
            restorant,
            openCamera,
            onButtonClicked,
            addToFavorite,
            removeFromFavorite
            )
    }

}

@Composable
fun RestorantScreen(
    restorant: Restorant,
    openCamera: () -> Unit,
    onButtonClicked: (String) -> Unit ={},
    addToFavorite: (Restorant)-> Unit,
    removeFromFavorite: (Restorant) -> Unit
) {
    //Restorants1(RestorantList.list)
    //RestorantPage(restorant = RestorantList.list[0])
    RestorantPage(
        restorant = restorant,
        openCamera = openCamera,
        onButtonClicked = onButtonClicked,
        addToFavorite = addToFavorite,
        removeFromFavorite = removeFromFavorite)

}

@Composable
fun RestorantPage(
    modifier: Modifier = Modifier,
    restorant: Restorant,
    openCamera: () -> Unit,
    onButtonClicked: (String) -> Unit={},
    addToFavorite: (Restorant)-> Unit,
    removeFromFavorite: (Restorant) -> Unit
) {
    var ayt by remember { mutableStateOf(false) }
    var menuClicked by remember { mutableStateOf(true) }
    var reviewsClicked by remember { mutableStateOf(false) }
    var reserveClicked by remember { mutableStateOf(false) }
    Surface(
        modifier = Modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(restorant.card_img.dp) //??? dimensione verticale immagine

            ) {
                Box(
                    //contentAlignment = Alignment.TopEnd
                ) {
                    Image(
                        //painter = painterResource(R.drawable.pizza),
                        painter = painterResource(restorant.card_img),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .height(150.dp)
                            .fillMaxWidth()
                    )
                    //BackButton()

                }
            }

            Column {
                Row {
                    Image(
                        painter = painterResource(restorant.logo),
                        //painter = painterResource(res.logo),
                        contentDescription = "Contact profile picture",
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
                    Column() {
                        Text(
                            text = restorant.name,
                            fontFamily = FontFamily.Serif,
                            fontSize = 25.sp
                        )
                        Text(
                            text = restorant.tipo,
                            fontStyle = FontStyle.Italic,
                            fontSize = 18.sp
                        )
                        Text(
                            text = restorant.via,
                            fontStyle = FontStyle.Italic,
                            fontSize = 15.sp
                        )
                        Text(
                            text = "Tel: 344-33365688"
                        )
                        Row {
                            RestorantRankStars(restorant = restorant)
                            /*
                            for (i in 1..5)
                                Icon(
                                    Icons.Rounded.Star,
                                    contentDescription = null
                                )*/

                        }

                    }
                    Box(
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Column(
                            horizontalAlignment = Alignment.End
                        ) {
                            FavoriteButton(
                                restorant,
                                addToFavorite = addToFavorite,
                                removeFromFavorite = removeFromFavorite
                            )
                            //ActivateButton(openCamera=openCamera)
                            ReviewButton(onButtonClicked = onButtonClicked, restorant)
                        }
                    }


                }
                Row {
                    RestorantNavigationBar(
                        menu = {menuClicked = true; reserveClicked = false; reviewsClicked = false},
                        review = {menuClicked = false; reserveClicked = false; reviewsClicked = true},
                        reserve = {menuClicked = false; reserveClicked = true; reviewsClicked = false}
                    )
                }

                if ( menuClicked ) {
                    MenuColumn(restorant)//, ayt)
                }
                if( reserveClicked ) {
                    ReservationScreen(restorant)
                }
                if  (reviewsClicked)  {
                    ReviewColumn(reviews = restorant.reviews)
                }

                //Reservation()
                //ReviewColumn()

            }
        }
    }
}

@Composable
fun MenuColumn(res: Restorant){//, table_is_active: Boolean){
    Menu(res.menu)//, table_is_active)
}

@Composable
fun Menu(menu: List<Plate>){//, table_is_active: Boolean){
    LazyColumn( horizontalAlignment = Alignment.CenterHorizontally){
        items(menu) {plate->
            MenuItem(plate)//, table_is_active)
        }
        item {
            if (false){//table_is_active) {
                Button(
                    onClick = { /*TODO*/ },) {
                    Text("Complete your Order")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TableforYouTheme {
        //MenuItem(MenuPizzeria.list[0])
        //Menu(MenuPizzeria.list)
        //RestorantPageScreen(id = 1)
    }
}

@Composable
fun MenuItem(plate: Plate){//, table_is_active: Boolean){
    //var table_is_active = false
    var count by remember { mutableStateOf(0) }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            //.height(100.dp)
            .border(width = 0.5.dp, color = Color.Black, shape = RectangleShape)
            .padding(all = 15.dp)


    ){
        Row (
            modifier = Modifier.width(250.dp)
        ){


            Column(
                //modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = plate.name,
                    fontSize = 20.sp
                )
                Text(
                    text = plate.description,
                    fontSize = 15.sp,
                    //modifier = Modifier.fillMaxWidth()
                )

            }
        }
        Text(
            text = plate.price.toString() + "€",
            fontSize =20.sp,
            //textAlign = TextAlign.Right
        )
        if(false){ //table_is_active) {
            StatefulCounter()


        }
    }
}

@Composable
fun StatelessCounter(count: Int,onIncrement: () -> Unit, onDecrement: () -> Unit, modifier: Modifier){
    Row {
        Button(
            onClick = onDecrement,
            modifier = Modifier.size(20.dp),
            shape = RectangleShape,
            contentPadding = PaddingValues(0.dp)
        ) {
            Text("-")
        }
        Text(
            "$count",
            fontSize = 20.sp
        )
        Button(
            onClick = onIncrement,
            modifier = Modifier.size(20.dp),
            shape = RectangleShape,
            contentPadding = PaddingValues(0.dp)
        ) {
            Text("+")
        }

    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, {count--}, modifier)
}







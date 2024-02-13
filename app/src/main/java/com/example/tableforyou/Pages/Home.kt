package com.example.tableforyou.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.tableforyou.Data.RISTORANTI.RISTORANTIDADB
import com.example.tableforyou.Data.Restorant
import com.example.tableforyou.Elements.FavoriteButton
import com.example.tableforyou.Elements.RestorantRankStars
import com.example.tableforyou.Elements.SearchBar


@Composable
fun HomeScreen(modifier: Modifier = Modifier, onClickOpenRestorant: (String) -> Unit = {}){
    Column(){
        SearchBar()
        RestorantCardColumn(onClickOpenRestorant = onClickOpenRestorant)

    }
}

@Composable
fun RestorantCardColumn(modifier: Modifier = Modifier,onClickOpenRestorant: (String) -> Unit = {}) {
    //Restorants(RestorantList.list, onClickOpenRestorant)
    Restorants(RISTORANTIDADB, onClickOpenRestorant)
}

@Composable
fun Restorants(restorant: List<Restorant>,onClickOpenRestorant: (String) -> Unit = {}) {
    LazyColumn {
        items(restorant) { restorant ->
            RestorantCard(Modifier ,restorant, onClickOpenRestorant)

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestorantCard(modifier: Modifier = Modifier, res: Restorant, onClickOpenRestorant: (String) -> Unit = {}) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(all = 20.dp)
            .clickable { onClickOpenRestorant(res.name) }
        ,
        //onClick = onClickOpenRestorant
    ) {

        Surface(
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
        ) {

            Column(
                verticalArrangement = Arrangement.Center
            ) {


                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Image(
                            //painter = painterResource(R.drawable.pizza),
                            painter = painterResource(res.card_img),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .height(150.dp)
                                .fillMaxWidth()
                        )
                        FavoriteButton()
                    }

                }
                Column {
                    Row {
                        Row {
                            Image(
                                //painter = painterResource(R.drawable.muzon),
                                painter = painterResource(res.logo),
                                contentDescription = "Contact profile picture",
                                modifier = Modifier
                                    // Set image size to 40 dp
                                    .size(40.dp)
                                    // Clip image to be shaped as a circle
                                    .clip(CircleShape)
                                    .border(
                                        1.5.dp,
                                        MaterialTheme.colorScheme.primary,
                                        CircleShape
                                    )
                            )

                            Column {
                                Text(
                                    text = res.name,
                                    fontFamily = FontFamily.Serif
                                )
                                Text(
                                    text = res.tipo,
                                    fontStyle = FontStyle.Italic,

                                    )
                                Row() {
                                    RestorantRankStars(restorant = res)
                                    /*
                                    for (i in 1..5)
                                        Icon(
                                            Icons.Rounded.Star,
                                            contentDescription = null,
                                            modifier = Modifier.size(15.dp)
                                        ))*/
                                }


                            }
                            //FavoriteButton()
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = res.via,
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier.padding(horizontal = 10.dp)

                        )

                        Text("Aperto ")

                        /*
                        var distance = 3
                        Text("   $distance km from you")*/
                    }


                }
            }
        }

    }
}
/*
@Composable
fun RestorantCardColumn(modifier: Modifier = Modifier) {
    Restorants(RestorantList.list)
    /*
        LazyColumn(
            //verticalArrangement = Arrangement.spacedBy(8.dp),
            //contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            item {
                //Restorants(RestorantList.list)
            }
                for (i in 1..5)
                    RestorantCard(
                        Sfondo = R.drawable.pizza,
                        SfondoIcona = R.drawable.muzon,
                        Nome = "Da ciro",
                        Tipo = "Pizzeria",
                        Via = "Via dannata 24"
                    )
            }
        }
        }*/
}
 */

package com.example.tableforyou

/*
@Composable
private fun Greetings(){
    Surface(
        modifier = Modifier,
        color = MaterialTheme.colorScheme.background
    ){
        Column(verticalArrangement = Arrangement.SpaceBetween){
            //Greeting("Caraibi a tutti")
            //RestorantCard()
            val mess = Message("Muzon", "Hello, how do you feel today?", R.drawable.muzon)
            MessageCard(mess)
            Conversation(Sample.conversationSample, onShowchatClicked = { })
            provaCard()
        }


    }
}




@Composable
fun MessageCard(msg: Message){
    Row {
        Image (
            painter = painterResource(msg.img),
            contentDescription = "Contact profile picture" ,
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }
        // surfaceColor will be updated gradually from one color to the other
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        )

        Column(modifier= Modifier.clickable { isExpanded =!isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            // Add a vertical space between the author and message texts

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                // surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)) {
                Text(
                    text = msg.note,
                    modifier = Modifier.padding(all=4.dp),
                    color = Color.Black,
                    //style = MaterialTheme.typography.bodyMedium,
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium

                )
            }
        }
    }
}


@Composable
fun Conversation(messages: List<Message>, onShowchatClicked: () -> Unit ) {
    Button(onClick = onShowchatClicked ) {
        Text("Back")
    }
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)

        }

    }
}

//@Preview
@Composable
fun PreviewConversation() {
    TableforYouTheme {
        Conversation(Sample.conversationSample, onShowchatClicked = { })
    }
}



@Composable
fun Greeting(name: String, onShowchatClicked: () -> Unit, modifier: Modifier = Modifier) {
    Row {
        Text(
            text = "Android says: $name!",
            modifier = modifier
        )
        Button(onClick = onShowchatClicked ) {
            Text("Show Chat")

        }
    }


}



//@Preview
@Composable
fun provaCard(modifier: Modifier = Modifier){
    Card(){
        Column ( verticalArrangement = Arrangement.Center){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                //.wrapContentWidth(Alignment.CenterHorizontally)
                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Image(
                    painter = painterResource(R.drawable.muzon),
                    contentDescription = "Contact profile picture",
                    modifier = Modifier
                        // Set image size to 40 dp
                        .size(40.dp)
                        // Clip image to be shaped as a circle
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
                )
                //Spacer(modifier = Modifier.width(200.dp))
                //var active = remember { mutableStateOf(true)}
                var active by remember { mutableStateOf(true)}

                Button(
                    onClick = { active = !active },
                    shape = CircleShape,
                    //colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Icon(
                        if (active) {
                            Icons.Rounded.Add
                            //contentDescription = null
                        }else {
                            Icons.Rounded.FavoriteBorder
                            //contentDescription = null
                        },
                        contentDescription = null
                    )

                }
            }
            Text(
                text = "Titolo",
                fontSize = 50.sp

            )
            Text(
                text = "Sottotitolo"
            )
            Text(
                text = "Descrizione"
            )

        }

    }

}


/*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppR(modifier: Modifier = Modifier) {
    TableforYouTheme {
        Scaffold(
            bottomBar = { BottomNavigationBar() }
        )
        { padding ->
            RestorantPageScreen(Modifier.padding(padding))
        }
    }
}

@Composable
fun Myapp2(modifier: Modifier = Modifier){
    //Greetings()
    var show by remember { mutableStateOf(true) }
    Column() {

        if (show) {
            Greeting("Caraibi a tutti", onShowchatClicked = { show = !show })

        } else {
            Conversation(Sample.conversationSample, onShowchatClicked = { show = !show })

        }
        provaCard()
    }

}*/


/*
@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    Column(){
    SearchBar()
    RestorantCardColumn()
    }
}
*/





/*
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SearchBar(modifier: Modifier = Modifier){
    TextField(
        value= "Search",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            unfocusedLabelColor = MaterialTheme.colorScheme.surface,
            focusedLabelColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(stringResource(R.string.app_name))
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp)

    )
}

*/




/*
@Preview
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

@Preview
@Composable
fun FavoriteButton() {
    Spacer(modifier = Modifier.width(170.dp)) //questo è temporaneo
    // probabilmente va modificato
    Button(
        onClick = {  },
        shape = CircleShape,
        modifier = Modifier
            .size(60.dp)


        ,
        contentPadding = PaddingValues(all = 7.dp),
        elevation = ButtonDefaults.buttonElevation(),
        enabled = false,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Red,
            disabledContainerColor = Color.Red ,
            disabledContentColor = Color.White
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
*/
/*
//@Preview
@Composable
fun RestorantCard(modifier: Modifier = Modifier, res: Restorant) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(all = 20.dp)
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
                                        for (i in 1..5)
                                            Icon(
                                                Icons.Rounded.Star,
                                                contentDescription = null,
                                                modifier = Modifier.size(15.dp)
                                            )
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

                            Text("Aperto")
                        }


                    }
                }
            }

        }
    }
*/
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



/*
@Composable
fun RestorantNavigationBar(modifier: Modifier = Modifier){
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
            selected = true ,
            onClick = { /*TODO*/ },
        )
        NavigationBarItem(
                icon = {
                    Row() {
                        Text("Reserve a Table")
                        //Icons.Rounded.ArrowDropDown
                    }
                },

        //label = { },
        selected = false ,
        onClick = { /*TODO*/ },
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
            onClick = { /*TODO*/ },
        )
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier){
    NavigationBar {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Rounded.Home,
                    contentDescription = null
                )
            },
            label = {
                Text("Home")

            },
            selected = false ,
            onClick = { /*TODO*/ },
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Rounded.Favorite,
                    contentDescription = null
                )
            },
            label = {
                Text("Favorite")

            },
            selected = false ,
            onClick = { /*TODO*/ },
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Rounded.DateRange,
                    contentDescription = null
                )
            },
            label = {
                Text("Reservations")

            },
            selected = false ,
            onClick = { /*TODO*/ },
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Rounded.Settings,
                    contentDescription = null
                )
            },
            label = {
                Text("Settings")

            },
            selected = false ,
            onClick = { /*TODO*/ },
        )

    }
}


*/


/*
@Preview
@Composable
fun RestorantCradPreview() {
    TableforYouTheme {
        RestorantCard(
            Sfondo = R.drawable.pizza ,
            SfondoIcona = R.drawable.muzon ,
            Nome = "Da ciro" ,
            Tipo = "Pizzeria" ,
            Via = "Via dannata 24" )

    }
}
*/








*/

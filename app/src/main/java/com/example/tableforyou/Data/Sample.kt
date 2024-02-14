package com.example.tableforyou.Data

import com.example.tableforyou.Elements.computerank
import com.example.tableforyou.R

val muz = R.drawable.muzon
val gas = R.drawable.axel
val path = "android.resource://com.example.tableforyou/"
object Users {
    val list : List<User> = listOf(
        User(
            name = "Muzon",
            mail = "user@mail.it",
            profile_img = path + R.drawable.muzon,
            preferred = listOf<Restorant>(
                Restorant(
                    name ="Pizzeria da ciro",
                    tipo = "Pizzeria",
                    via = "via bella napoli 34",
                    logo = R.drawable.muzon,
                    card_img = R.drawable.pizza,
                    menu = MenuPizzeriaCiro.list,
                    //reviews = PizzeriaCiroReviews.list,
//                    rank = computerank(PizzeriaCiroReviews.list),
                    tables = PizzeriaCiroTables.list
                ),
                Restorant(
                    name ="Il picchio rosso",
                    tipo = "Trattoria",
                    via = "via ascoli 47",
                    logo = R.drawable.picchio,
                    card_img = R.drawable.carbo,
                    menu = MenuTrattoriaPicchioRosso.list,
                    //reviews = TrattoriaPicchioRossoReviews.list,
                    //rank = computerank(TrattoriaPicchioRossoReviews.list),
                    tables = TrattoriaPicchioRossoTables.list

                )
                //RestorantList.list[0],
                //RestorantList.list[2]
            ),
            reservations = listOf(),
            reviews = listOf(),
        ),
        User(
            name = "Axel",
            profile_img = path + R.drawable.axel,
            preferred = listOf<Restorant>(),
            reservations = listOf(),
            reviews = listOf(),
        ),
        User(
            name = "Franchino",
            profile_img = path + R.drawable.cinghiale,
            preferred = listOf<Restorant>(),
            reservations = listOf(),
            reviews = listOf(),
        )


    )
}

object PizzeriaCiroTables {
    val list: List<Table> = listOf(
        Table(
            num = 1,
            seats = 8,
            restorant = null, //RestorantList.list[0],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 2,
            seats = 6,
            restorant = null, //RestorantList.list[0],
            reserved = false,
            reservation = null
        ),
        Table(
            num = 3,
            seats = 4,
            restorant = null, //RestorantList.list[0],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 4,
            seats = 8,
            restorant = null, //RestorantList.list[0],
            reserved = false,
            reservation = null
        )

    )
}

object PizzeriaCiroReviews {
    val list : List<Review> = listOf(
        Review(
            user = User(),//Users.list[0],
            note = "Very good pizzeria on the center of Naples. Great choice of pizzas and very good prices. The chef is amazing and very funny. I've taken the most famous pizza of naplese the Marinana",
            vote = 5,
            img = "android.resource://com.example.tableforyou/"+ R.drawable.pizza_napoli
        ),
        Review(
            user = Users.list[1],
            note = "I like Diavola very much",
            vote = 4,
            img = "android.resource://com.example.tableforyou/"+ R.drawable.diavola
        ),
        Review(
            user = Users.list[2],
            note = "I don't like the pizza of this restorant",
            vote = 3,
            img = null,
        ),
        Review(
            user = Users.list[2],
            note = "I don't like the pizza of this restorant",
            vote = 1,
            img = null,
        ),
        Review(
            user = Users.list[2],
            note = "I don't like the pizza of this restorant",
            vote = 1,
            img = null,
        )
    )
}

object MenuPizzeriaCiro {
    val list : List<Plate> = listOf(
        Plate(
            name = "Marinara",
            price = 5,
            description = "Pomodoro, Alici, Origano"
        ),
        Plate(
            name = "Margherita",
            price = 6,
            description = "Pomodoro, Mozzarella, Basilico"
        ),
        Plate(
            name = "Diavola",
            price = 7,
            description = "Pomodoro, Mozzarella, Salame piccante"
        ),
        Plate(
            name = "Capricciosa",
            price = 9,
            description = "Pomodoro, Mozzarella, Olive, Speck, Uova, Carciofi"
        ),
        Plate(
            name = "Salsiccia e Patate",
            price = 8,
            description = "Mozzarella, Salsiccia, Patate"
        ),
        Plate(
            name = "Boscaiola",
            price = 8,
            description = "Pomodoro, Mozzarella, Salsiccia, Funghi"
        ),
        Plate(
            name = "Peperoni e Salsiccia",
            price = 8,
            description = "Pomodoro, Mozzarella, Salsiccia, Peperoni"
        ),
        Plate(
            name = "Fiori di zucca e alici",
            price = 7,
            description = "Mozzarella, Fiori di zucca, Alici"
        ),
        Plate(
            name = "Quattro formaggi",
            price = 6,
            description = "Mozzarella, Gorgonzola, Fontina, Provola"
        ),
        Plate(
            name = "Supplì",
            price = 2,
            description = "Supplì al pomodoro e mozzarella"
        ),
        Plate(
            name = "Crocchetta",
            price = 2,
            description = ""
        ),
	Plate(
            name = "Baccalà fritto",
            price = 3,
            description = ""
        ),
	Plate(
            name = "Acqua 1L",
            price = 2,
            description = ""
        ),
	Plate(
            name = "Birra 66cl",
            price = 3,
            description = ""
        ),
	Plate(
            name = "Coca cola 75cl",
            price = 2,
            description = ""
        ),
    )
}

val menupizzaCiro=listOf(
    "Marinara",
    "Margherita",
    "Diavola",
    "Capricciosa",
    "Salsiccia e patate",
    "Boscaiola",
    "Peperoni e Salsiccia",
    "Fiori di zucca e alici",
    "Quattro formaggi",
    "Suppli",
    "Crocchetta",
    "Baccalà fritto",
    "Acqua 1L",
    "Birra 66cl",
    "Coca cola 75cl"
)



//-----------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------


object TrattoriaPicchioRossoTables {
    val list: List<Table> = listOf(
        Table(
            num = 1,
            seats = 4,
            restorant = null,//RestorantList.list[1],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 2,
            seats = 6,
            restorant = null,//RestorantList.list[1],
            reserved = false,
            reservation = null
        ),
        Table(
            num = 3,
            seats = 5,
            restorant = null,//RestorantList.list[1],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 4,
            seats = 12,
            restorant = null,//RestorantList.list[1],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 5,
            seats = 6,
            restorant = null,//RestorantList.list[1],
            reserved = false,
            reservation = null
        )

    )
}

object TrattoriaPicchioRossoReviews {
    val list : List<Review> = listOf(
        Review(
            user = Users.list[2],
            note = "Amo questa trattoria. Personale gentile, cibo ottimo.",
            vote = 5,
            img = null,
        ),
        Review(
            user = Users.list[1],
            note = "Carbonara is the food for gods",
            vote = 5,
            img = null,
        ),
        Review(
            user = Users.list[0],
            note = "Very good restaurant, but the service is very slow",
            vote = 3,
            img = null,
        ),
        Review(
            user = Users.list[0],
            note = "I primi non sono arrivati tutti insieme. La grigliata è molto buona.",
            vote = 3,
            img = null,
        ),
        Review(
            user = Users.list[1],
            note = "La grigliata mista era ottima. Il vitello molto tenero!",
            vote = 5,
            img = null,
        ),
    )
}


val menutrattoriaPicchioRosso=listOf(
    "Carbonara",
    "Amatriciana",
    "Cacio e pepe",
    "Gricia",
    "Grigliata mista",
    "Agnello",
    "Patate al forno",
    "Scarola"
)

object MenuTrattoriaPicchioRosso {
    val list : List<Plate> = listOf(
        Plate(
            name = "Carbonara",
            price = 9,
            description = "Pomodoro, Alici, Origano"
        ),
        Plate(
            name = "Amatriciana",
            price = 8,
            description = "Pomodoro, Mozzarella, Basilico"
        ),
        Plate(
            name = "Cacio e pepe",
            price = 7,
            description = "Pomodoro, Mozzarella, Salame piccante"
        ),
        Plate(
            name = "Gricia",
            price = 8,
            description = "Pomodoro, Mozzarella, Salame piccante"
        ),
	Plate(
            name = "Grigliata mista",
            price = 12,
            description = "Agnello, Salsiccia, Fettina di maiale, Arrosticini"
        ),
	Plate(
            name = "Agnello",
            price = 13,
            description = "alla brace"
        ),
	Plate(
            name = "Patate al forno",
            price = 5,
            description = ""
        ),
	Plate(
            name = "Scarola",
            price = 6,
            description = "con uvetta e pinoli"
        )
    )
}



//-----------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------


object RistoranteTagliereVolanteTables {
    val list: List<Table> = listOf(
        Table(
            num = 1,
            seats = 4,
            restorant = null,//RestorantList.list[1],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 2,
            seats = 6,
            restorant = null,// RestorantList.list[1],
            reserved = false,
            reservation = null
        ),
        Table(
            num = 3,
            seats = 5,
            restorant = null,//RestorantList.list[1],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 4,
            seats = 12,
            restorant = null,//RestorantList.list[1],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 5,
            seats = 6,
            restorant = null,//RestorantList.list[1],
            reserved = false,
            reservation = null
        ),
	Table(
            num = 6,
            seats = 2,
            restorant = null,//RestorantList.list[1],
            reserved = true,
            reservation = null
        ),

    )
}

object RistoranteTagliereVolanteReviews {
    val list : List<Review> = listOf(
        Review(
            user = Users.list[2],
            note = "Cibo ottimo. Abbiamo passato una piacevole cena, sicuramente torneremo! Tagliata di picanha proprio buona. Personale gentile.",
            vote = 5,
            img = null,
        ),
        Review(
            user = Users.list[1],
            note = "Personale efficiente, location con bel panorama. Abbiamo provato due primi, molto buoni. L'antipasto della casa davvero abbondante.",
            vote = 5,
            img = null,
        ),
        Review(
            user = User(),//Users.list[0],
            note = "Cibo molto buono. Servizio leggermente lento.",
            vote = 4,
            img = null,
        ),
        Review(
            user = Users.list[1],
            note = "Antipasto della casa molto buono. I paccheri con il baccalà avevano un sapore molto equilibrato. Il polpo era molto tenero.",
            vote = 5,
            img = null,
        ),
    )
}


val menuristoranteTagliereVolante=listOf(
    "Tagliere di salumi e formaggi",
    "Tagliere di formaggi",
    "Bruschetta pulled pork",
    "Olive ascolane di pesce",
    "Pennette salmone e asparagi",
    "Paccheri baccalà, pachino, olive nere",
    "Fusilli al ragù di pecora",
    "Gnocchi alla sorrentina",
    "Polpette su crema di carciofi",
    "Baccalà mantecato con peperoni",
    "Polpo su puré",
    "Tagliata di Picanha con cubo croccante di patate",
    "Patate al forno",
    "Scarola",
    "Insalata"
)

object MenuRistoranteTagliereVolante {
    val list : List<Plate> = listOf(
        Plate(
            name = "Antipasto della casa X2",
            price = 32,
            description = "Selezione di salumi e formaggi, con miele, bruschette e fritti. Per due persone"
        ),
        Plate(
            name = "Tagliere di formaggi",
            price = 14,
            description = "Selezione dei formaggi di zona, con marmellate e miele"
        ),
        Plate(
            name = "Bruschetta pulled pork",
            price = 6,
            description = "Bruschetta con maiale sfilacciato e cipolla caramellata"
        ),
        Plate(
            name = "Olive ascolane di pesce",
            price = 8,
            description = "Olive ascolane di merluzzo"
        ),
	Plate(
            name = "Pennette salmone e asparagi",
            price = 12,
            description = "Pennette con salmone, punte di asparagi, philadelphia, scorze di limone"
        ),
	Plate(
            name = "Paccheri baccalà, pachino, olive nere",
            price = 14,
            description = "Paccheri baccalà, pachino, olive nere, scorza di limone, prezzemolo"
        ),
	Plate(
            name = "Fusilli al ragù di pecora",
            price = 12,
            description = "Fusilli, ragù di sugo di carne di pecora"
        ),
	Plate(
            name = "Gnocchi alla sorrentina",
            price = 11,
            description = "Gnocchi, salsiccia, funghi"
        ),
	Plate(
            name = "Polpette su crema di carciofi",
            price = 13,
            description = "Polpette di manzo, crema di carciofi, capperi e olive nere"
        ),
	Plate(
            name = "Baccalà mantecato con peperoni",
            price = 15,
            description = "Insalata di baccalà mantecato e peperoni rossi arrosto"
        ),
	Plate(
            name = "Polpo su puré", 
            price = 14,
            description = "Tentacoli di polpo arrosto, su puré di patate dolci"
        ),
	Plate(
            name = "Tagliata di Picanha con cubo croccante di patate",
            price = 18,
            description = "Tagliata di picanha, tortino di patate croccanti a sfoglia"
        ),
	Plate(
            name = "Patate al forno",
            price = 5,
            description = ""
        ),
	Plate(
            name = "Scarola",
            price = 6,
            description = "con uvetta e pinoli"
        ),
	Plate(
            name = "Insalata",
            price = 5,
            description = ""
        )
    )
}



//-----------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------


object PanissimoTables {
    val list: List<Table> = listOf(
        Table(
            num = 1,
            seats = 4,
            restorant = null,//RestorantList.list[1],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 2,
            seats = 4,
            restorant = null,//RestorantList.list[1],
            reserved = false,
            reservation = null
        ),
        Table(
            num = 3,
            seats = 2,
            restorant = null,//RestorantList.list[1],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 4,
            seats = 12,
            restorant = null,//RestorantList.list[1],
            reserved = true,
            reservation = null
        ),
    )
}

object PanissimoReviews {
    val list : List<Review> = listOf(
        Review(
            user = Users.list[2],
            note = "Panini enormi. Io mangio tanto e comunque faccio difficoltà a finirne uno. Quello con il pulled pork è magico.",
            vote = 5,
            img = null,
        ),
        Review(
            user = Users.list[1],
            note = "Pochi panini nel menu, ma coprono tutti i gusti. Qualità accellente",
            vote = 5,
            img = null,
        ),
        Review(
            user = Users.list[0],
            note = "Troppa attesa per avere un panino.",
            vote = 2,
            img = null,
        ),
        Review(
            user = Users.list[0],
            note = "Posto piccolo, ambiente familiare. Cibo sempre fresco e di qualità. Panini belli grandi. Ho molto apprezzato il panino vegetariano con le melanzane fritte!",
            vote = 5,
            img = null,
        ),
    )
}


val menuPanissimo=listOf(
    "Il Vegetariano diverso",
    "Smoked Pork",
    "Il crucco",
    "Il frittatone",
    "Oktober dog",
    "Il polpetta",
    "Los pollos bananos",
    "Friariccia",
    "Classicone"
)

object MenuPanissimo {
    val list : List<Plate> = listOf(
        Plate(
            name = "Il Vegetariano diverso",
            price = 10,
            description = "Melanzane fritte dorate, pomodoro, formaggio, maionese aromatizzata con prezzemolo, capperi e pomodori secchi"
        ),
        Plate(
            name = "Smoked Pork",
            price = 14,
            description = "Pulled pork, salsa cheddar, cipolle caramellate, bacon croccante"
        ),
        Plate(
            name = "Il crucco",
            price = 13,
            description = "Wurstel artigianali di maiale, patate fritte in pastella, cetriolini, crauti saltati al burro, senape al miele, cipolla fritta sbriciolata"
        ),
        Plate(
            name = "Il frittatone",
            price = 12,
            description = "Salsiccia, Frittata di patate, formaggio, pancetta, salsa bbq, cipolla sbriciolata"
        ),
	Plate(
            name = "Il polpetta",
            price = 11,
            description = "Polpette di manzo cotte nel sugo, parmigiano, pecorino"
        ),
	Plate(
            name = "Los pollos bananos",
            price = 12,
            description = "Fettine panate di pollo, crema di pomodori secchi, pancetta croccante"
        ),
	Plate(
            name = "Friariccia",
            price = 13,
            description = "Porchetta di ariccia, friarielli, zucchine alla scapece"
        ),
	Plate(
            name = "Classicone",
            price = 11,
            description = "Salsiccia, broccoli, caciottone"
        )
    )
}



//-----------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------


object BettolaCinghialeContentoTables {
    val list: List<Table> = listOf(
        Table(
            num = 1,
            seats = 4,
            restorant = null,//RestorantList.list[1],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 2,
            seats = 6,
            restorant = null,//RestorantList.list[1],
            reserved = false,
            reservation = null
        ),
        Table(
            num = 3,
            seats = 8,
            restorant = null,//RestorantList.list[1],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 4,
            seats = 2,
            restorant = null,//RestorantList.list[1],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 5,
            seats = 6,
            restorant = null,//RestorantList.list[1],
            reserved = false,
            reservation = null
        ),
	Table(
            num = 6,
            seats = 10,
            restorant = null,//RestorantList.list[1],
            reserved = true,
            reservation = null
        ),

    )
}

object BettolaCinghialeContentoReviews {
    val list : List<Review> = listOf(
        Review(
            user = Users.list[2],
            note = "Consigliatissimo per gli amanti della cacciaggione. I proprietari sono molto attenti alla freschezza e alla qualità del prodotto.",
            vote = 5,
            img = null,
        ),
        Review(
            user = Users.list[0],
            note = "Cibo molto buono. Servizio un po lento. Tornerò volentieri",
            vote = 4,
            img = null,
        ),
	Review(
            user = Users.list[1],
            note = "Cinghiale molto tenero. Cucinato in tutti i modi.",
            vote = 5,
            img = null,
        ),
    )
}


val menubettolaCinghialeContento=listOf(
    "pappardelle al ragù di cinghiale", 
    "tagliatelle al cinghiale", 
    "cinghiale in umido", 
    "cinghiale brasato", 
    "cinghiale arrosto", 
    "cinghiale alla birra",
    "Patate al forno",
    "Peperoni arrosto",
    "Insalata"
)

object MenuBettolaCinghialeContento {
    val list : List<Plate> = listOf(
        Plate(
            name = "pappardelle al ragù di cinghiale",
            price = 12,
            description = "ragù bianco di cinghiale"
        ),
        Plate(
            name = "tagliatelle al cinghiale",
            price = 11,
            description = "con pezzi interi di cinghiale"
        ),
        Plate(
            name = "cinghiale in umido",
            price = 10,
            description = ""
        ),
        Plate(
            name = "cinghiale brasato",
            price = 13,
            description = ""
        ),
	Plate(
            name = "cinghiale arrosto",
            price = 11,
            description = ""
        ),
	Plate(
            name = "cinghiale alla birra",
            price = 14,
            description = ""
        ),
	Plate(
            name = "Patate al forno",
            price = 5,
            description = ""
        ),
	Plate(
            name = "Peperoni arrosto",
            price = 5,
            description = ""
        ),
	Plate(
            name = "Insalata",
            price = 5,
            description = ""
        )
    )
}



//-----------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------




//val r1: Restorant = RestorantList.list[0]

object RestorantList{
    val list : MutableList<Restorant> = mutableListOf(
        Restorant(
            name ="Pizzeria da ciro",
            tipo = "Pizzeria",
            via = "via bella napoli 34",
            logo = R.drawable.muzon,
            card_img = R.drawable.pizza,
            menu = MenuPizzeriaCiro.list,
            reviews = PizzeriaCiroReviews.list,
            rank = computerank(PizzeriaCiroReviews.list),
            tables = PizzeriaCiroTables.list
        ),
        Restorant(
            name ="Il picchio rosso",
            tipo = "Trattoria",
            via = "via ascoli 47",
            logo = R.drawable.picchio,
            card_img = R.drawable.carbo,
            menu = MenuTrattoriaPicchioRosso.list,
            reviews = TrattoriaPicchioRossoReviews.list,
            rank = computerank(TrattoriaPicchioRossoReviews.list),
            tables = TrattoriaPicchioRossoTables.list

        ),
        Restorant(
            name ="Il tagliere volante",
            tipo = "Ristorante",
            via = "via fonti del clitunno 66",
            logo = R.drawable.muzon,
            card_img = R.drawable.tagliere,
            menu = MenuRistoranteTagliereVolante.list,
            reviews = RistoranteTagliereVolanteReviews.list,
            rank = 4,
            tables = RistoranteTagliereVolanteTables.list


        ),
        Restorant(
            name ="Paninissimo",
            tipo = "Paninoteca",
            via = "via corta 1",
            logo = R.drawable.axel,
            card_img = R.drawable.paninoteca,
            menu = MenuPanissimo.list,
            reviews = PanissimoReviews.list,
            rank = 4,
            tables = PanissimoTables.list


        ),
        Restorant(
            name ="Il cinghiale contento",  
            tipo = "Bettola",
            via = "via niso 4",
            logo = R.drawable.cinghiale,
            card_img = R.drawable.bistecca,
            menu = MenuBettolaCinghialeContento.list,
            reviews = BettolaCinghialeContentoReviews.list,
            rank = 4,
            tables = BettolaCinghialeContentoTables.list


        )

    )
    fun getRestorant(restorantName: String?): Restorant {
        return list.first { it.name == restorantName }
    }
}








package com.example.tableforyou.Data

/*
val muz = R.drawable.muzon
val gas = R.drawable.axel

object Users {
    val list : List<User> = listOf(
        User(
            name = "Muzon",
            profile_img = R.drawable.muzon,
            preferred = listOf(),
            reservations = listOf(),
            reviews = listOf(),
        ),
        User(
            name = "Axel",
            profile_img = R.drawable.axel,
            preferred = listOf<Restorant>(),
            reservations = listOf(),
            reviews = listOf(),
        ),
        User(
            name = "Franchino",
            profile_img = R.drawable.cinghiale,
            preferred = listOf<Restorant>(),
            reservations = listOf(),
            reviews = listOf(),
        )


    )
}

object PizzeriaTables {
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

object TrattoriaTables {
    val list: List<Table> = listOf(
        Table(
            num = 1,
            seats = 4,
            restorant = RestorantList.list[1],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 2,
            seats = 6,
            restorant = RestorantList.list[1],
            reserved = false,
            reservation = null
        ),
        Table(
            num = 3,
            seats = 5,
            restorant = RestorantList.list[1],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 4,
            seats = 12,
            restorant = RestorantList.list[1],
            reserved = true,
            reservation = null
        ),
        Table(
            num = 5,
            seats = 6,
            restorant = RestorantList.list[1],
            reserved = false,
            reservation = null
        )

    )
}

object TrattoriaReviews {
    val list : List<Review> = listOf(
        Review(
            user = Users.list[2],
            note = "I love this trattoria",
            vote = 5,
            img = "",
        ),
        Review(
            user = Users.list[1],
            note = "Carbonara is the food fo the gods",
            vote = 5,
            img = "",
        ),
        Review(
            user = Users.list[0],
            note = "Very good restorant , but the service is very slow",
            vote = 3,
            img = "",
        ),
        Review(
            user = Users.list[0],
            note = "Very good restorant , but the service is very slow",
            vote = 3,
            img = "",
        ),
        Review(
            user = Users.list[1],
            note = "Carbonara is the food fo the gods",
            vote = 5,
            img = "",
        ),
    )
}

object PizzeriaReviews {
    val list : List<Review> = listOf(
        Review(
            user = Users.list[0],
            note = "Very good pizzeria on the center of Naples. Great choice of pizzas and very good prices. The chef is amazing and very funny. I've taken the most famous pizza of naplese the Marinana",
            vote = 5,
            img = "android.resource://com.example.tableforyou/"+R.drawable.pizza_napoli
        ),
        Review(
            user = Users.list[1],
            note = "I like Diavola very much",
            vote = 4,
            img = "android.resource://com.example.tableforyou/"+ R.drawable.diavola //Uri.parse("android.resource://com.example.tableforyou/"+ R.drawable.diavola)
        ),
        Review(
            user = Users.list[2],
            note = "I don't like the pizza of this restorant",
            vote = 3,
            img = "",
        ),
        Review(
            user = Users.list[2],
            note = "I don't like the pizza of this restorant",
            vote = 1,
            img = "",
        ),
        Review(
            user = Users.list[2],
            note = "I don't like the pizza of this restorant",
            vote = 1,
            img = "",
        )
    )
}

object MenuPizzeria {
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
            name = "Diavola",
            price = 7,
            description = "Pomodoro, Mozzarella, Salame piccante"
        ),
        Plate(
            name = "Diavola",
            price = 7,
            description = "Pomodoro, Mozzarella, Salame piccante"
        ),
        Plate(
            name = "Diavola",
            price = 7,
            description = "Pomodoro, Mozzarella, Salame piccante"
        ),
    )
}

val menupizza=listOf(
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


object MenuTrattoria {
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
        )
    )
}



//val r1: Restorant = RestorantList.list[0]

object RestorantList{
    val list : MutableList<Restorant> = mutableListOf(
        Restorant(
            name ="Pizzeria da Ciro",
            tipo = "Pizzeria",
            via = "via bella napoli 34",
            logo = R.drawable.muzon,
            card_img = R.drawable.pizza,
            menu = MenuPizzeria.list,
            reviews = PizzeriaReviews.list,
            rank = computerank(PizzeriaReviews.list),
            tables = listOf()//PizzeriaTables.list
        ),
        Restorant(
            name ="Il picchio rosso",
            tipo = "Trattoria",
            via = "via ascoli 47",
            logo = R.drawable.picchio,
            card_img = R.drawable.carbo,
            menu = MenuTrattoria.list,
            reviews = TrattoriaReviews.list,
            rank = computerank(TrattoriaReviews.list),
            tables = listOf() // TrattoriaTables.list

        ),
        Restorant(
            name ="Il tagliere volante",
            tipo = "Ristorante",
            via = "via della dannazione 66",
            logo = R.drawable.muzon,
            card_img = R.drawable.tagliere,
            menu = listOf(),
            reviews = listOf(),
            rank = 4,
            tables = listOf()


        ),
        Restorant(
            name ="Paninissimo",
            tipo = "Paninoteca",
            via = "via corta 1",
            logo = R.drawable.axel,
            card_img = R.drawable.paninoteca,
            menu = listOf(),
            reviews = listOf(),
            rank = 4,
            tables = listOf()


        ),
        Restorant(
            name ="Il cinghiale contento",
            tipo = "Bettola",
            via = "via della disperazione 4",
            logo = R.drawable.cinghiale,
            card_img = R.drawable.bistecca,
            menu = listOf(),
            reviews = listOf(),
            rank = 4,
            tables = listOf()


        )

    )
    fun getRestorant(restorantName: String?): Restorant {
        return list.first { it.name == restorantName }
    }
}



object FavoriteList{
    val list : List<Restorant> = listOf(
        Restorant(
            name ="Pizzeria da ciro",
            tipo = "Pizzeria",
            via = "via bella napoli 34",
            logo = R.drawable.muzon,
            card_img = R.drawable.pizza,
            menu = MenuPizzeria.list,
            reviews = PizzeriaReviews.list,
            rank = computerank(PizzeriaReviews.list),
            tables = listOf()
        ),
        Restorant(
            name ="Il cinghiale contento",
            tipo = "Bettola",
            via = "via della disperazione 4",
            logo = R.drawable.cinghiale,
            card_img = R.drawable.bistecca,
            menu = listOf(),
            reviews = listOf(),
            rank = 4,
            tables = listOf()


        )
    )

}




*/



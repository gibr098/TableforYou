package com.example.tableforyou.Data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database


class MyData {
    // Write a message to the database
    //val database = Firebase
     //.database("https://tableforyou-f235e-default-rtdb.europe-west1.firebasedatabase.app/")
    //val database = Firebase.database
    //val myRef = database.getReference("message")

    private lateinit var database: DatabaseReference


    fun writeNewUser(userId: String, name: String) {
        database = Firebase
            .database("https://tableforyou-f235e-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference

        val user = User(
            name = name,
            profile_img = "",//R.drawable.muzon,
            preferred = mutableListOf(),
            reservations = mutableListOf(),
            reviews = listOf(),
        )

        database.child("usersProva").child(userId).setValue(user)
    }

    fun writeRestorant(obj: Any, child: String) {
        database = Firebase
            .database("https://tableforyou-f235e-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference

        val restorantv = Restorant(
            "La stella Marina",
            "Ristopescheria",
            "via Bacoli 1",
            2131165375,
            2131165283,
            menu = listOf( Plate(
                name = "Risotto",
                price = 9,
                description = "Risotto ai frutti di mare"
            )),
            reviews = mutableListOf(),//listOf(Review(Users.list[1],"very good",5,img = null)),
            5,
            tables = listOf()
        )

        database.child("RESTORANTS").child(child).setValue(obj)


    }

    fun writeUser(name: String, mail: String, profile_img: String, child: String) {
        database = Firebase
            .database("https://tableforyou-f235e-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference

        var user = User(name,mail,profile_img)

        database.child("USERS").child(child).setValue(user)


    }
    fun writeUser1(user: User) {
        database = Firebase
            .database("https://tableforyou-f235e-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference

        database.child("USERS").child(user.name).setValue(user)


    }
    fun addPreferredUserRestorant(user:String, restorant: Restorant){
        database = Firebase
            .database("https://tableforyou-f235e-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference

        //database.child("PreferredOf$user").child(restorant.name).setValue(restorant)

    }

    fun addPreferredRestorant(username: String, name: String, tipo: String, via: String, logo: Int, card_img: Int ) {
        database = Firebase
            .database("https://tableforyou-f235e-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference
        var restorant = Restorant(name, tipo, via, logo, card_img)

        database.child("USERS").child(username).child("preferred").child(name).setValue(restorant)


    }
    fun postReview(note:String, vote: Int, img: String?, restorant: Restorant){
        database = Firebase
            .database("https://tableforyou-f235e-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference

        val rev = Review(user = UTENTIDADB, note = note, vote = vote)
        RestorantList.getRestorant(restorant.name).reviews.add(rev)
        writeRestorant(restorant,restorant.name)

        //database.child("ReviewsOf${restorant.name}").child("ReviewOf${UTENTIDADB.name}").setValue(rev)

    }
    fun addReservation(data:String, table: Table ,user: User){
        database = Firebase
            .database("https://tableforyou-f235e-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference


        val ri = ResInstance(user.name,data)
        val reservation = Reservation(table = table,data = data)
        if (Users.list.contains(user)){
            Users.getUser(user.name).reservations.add(reservation)
        }else{
            Users.list.add(user)
            Users.getUser(user.name).reservations.add(reservation)
        }
        for(elem in RestorantList.getRestorant((table.restorantname)).tables){
            if(elem.num == table.num){
                if(!elem.reservations.contains(ri)){
                    elem.reservations.add(ResInstance(user.name,data))
                }

            }
        }

        writeUser1(user)
        writeRestorant(RestorantList.getRestorant((table.restorantname)),table.restorantname)

        //database.child("ReviewsOf${restorant.name}").child("ReviewOf${UTENTIDADB.name}").setValue(rev)

    }


    fun addRestorantToFavorites(restorant: Restorant,user: User){
        database = Firebase
            .database("https://tableforyou-f235e-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference

        if (Users.list.contains(user)){
            Users.getUser(user.name).preferred.add(restorant)
        }else{
            Users.list.add(user)
            Users.getUser(user.name).preferred.add(restorant)
        }

        writeUser1(user)

        //database.child("ReviewsOf${restorant.name}").child("ReviewOf${UTENTIDADB.name}").setValue(rev)

    }

    fun removeRestorantFromFavorites(restorant: Restorant,user: User){
        database = Firebase
            .database("https://tableforyou-f235e-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference

        if (Users.list.contains(user)){
            Users.getUser(user.name).preferred.remove(restorant)
        }else{
            Users.list.add(user)
            Users.getUser(user.name).preferred.remove(restorant)
        }

        writeUser1(user)

        //database.child("ReviewsOf${restorant.name}").child("ReviewOf${UTENTIDADB.name}").setValue(rev)

    }

}


var UTENTIDADB by mutableStateOf(Users.list[0])
 var PREFERITIUTENTE = mutableListOf<Restorant>()

object RISTORANTI {
    var RISTORANTIDADB by mutableStateOf(RestorantList.list)
    fun getRes(restorantName: String?): Restorant {
        return RISTORANTIDADB.first { it.name == restorantName }
    }
}

/*
val muz = R.drawable.muzon
val gas = R.drawable.axel

object  Axel{
    val name = "Axel"
    val img = R.drawable.axel
}

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
            img = null,
        ),
        Review(
            user = Users.list[1],
            note = "Carbonara is the food fo the gods",
            vote = 5,
            img = null,
        ),
        Review(
            user = Users.list[0],
            note = "Very good restorant , but the service is very slow",
            vote = 3,
            img = null,
        ),
        Review(
            user = Users.list[0],
            note = "Very good restorant , but the service is very slow",
            vote = 3,
            img = null,
        ),
        Review(
            user = Users.list[1],
            note = "Carbonara is the food fo the gods",
            vote = 5,
            img = null,
        ),
    )
}

object PizzeriaReviews {
    val list : List<Review> = listOf(
        Review(
            user = Users.list[0],
            note = "Very good pizzeria on the center of Naples. Great choice of pizzas and very good prices. The chef is amazing and very funny. I've taken the most famous pizza of naplese the Marinana",
            vote = 5,
            img = Uri.parse("android.resource://com.example.tableforyou/"+ R.drawable.pizza_napoli)
        ),
        Review(
            user = Users.list[1],
            note = "I like Diavola very much",
            vote = 4,
            img = Uri.parse("android.resource://com.example.tableforyou/"+ R.drawable.diavola)
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

val menutrattoria=listOf(
    "Carbonara",
    "Amatriciana",
    "Cacio e pepe",
    "Gricia"
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
            tables = PizzeriaTables.list
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







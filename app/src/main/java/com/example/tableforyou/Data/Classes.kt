package com.example.tableforyou.Data

//import com.google.common.collect.Table

//@get:Exclude

data class User(
    val name: String = "",
    val mail: String = "",
    val profile_img: String = "",
    val preferred: MutableList<Restorant> = mutableListOf(),
    val reservations: List<Reservation> = listOf(),
    val reviews: List<Review> = listOf()
)


data class Review (
    val user: User = User(),
    val note: String = "",
    val vote: Int = 0,
    val img: String? = ""
)


data class Restorant(
    val name: String = "",
    val tipo: String = "",
    val via: String = "",
    val logo: Int = 0,
    val card_img: Int = 0,
    val menu: List<Plate> = listOf(),
    val reviews : MutableList<Review> = mutableListOf<Review>(),
    var rank: Int = 0,
    val tables: List<Table> = listOf()
)


data class Plate(
    val name: String = "",
    val price: Int = 0,
    val description: String = ""
)

data class Table(
    val num: Int = 0,
    val seats: Int = 0,
    val restorant: Restorant? = Restorant(),
    val reserved: Boolean = false,
    val reservation: Reservation? = Reservation()
)

data class Reservation(
    //val table: Table = Table(),
    val data: Int = 0,
    val user: User= User()
)

/*
data class User(
    val name: String,
    val profile_img: Int,
    val preferred: List<Restorant>,
    val reservations: List<Reservation>,
    val reviews: List<Review>
)

data class Review (val user: User, val note: String, val vote: Int, val img: Uri?)


data class Restorant(
    val name: String ,
    val tipo: String ,
    val via: String ,
    val logo: Int ,
    val card_img: Int,
    val menu: List<Plate>,
    val reviews : List<Review>,
    var rank: Int,
    val tables: List<Table>
)




data class Plate(val name: String, val price: Int, val description: String)

data class Table(val num: Int, val seats: Int, val restorant: Restorant?, val reserved: Boolean, val reservation: Reservation?)

data class Reservation(val table: Table, val data: Int, val user: User)
*/
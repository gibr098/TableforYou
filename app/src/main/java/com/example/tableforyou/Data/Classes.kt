package com.example.tableforyou.Data


data class User(
    val name: String,
    val profile_img: Int,
    val preferred: List<Restorant>,
    val reservations: List<Reservation>,
    val reviews: List<Review>
)

data class Review (val user: User, val note: String, val vote: Int, val img: Int?)

data class Restorant(
    val name: String,
    val tipo: String,
    val via: String,
    val logo: Int,
    val card_img: Int,
    val menu: List<Plate>,
    val reviews : List<Review>,
    var rank: Int,
    val tables: List<Table>
)

data class Plate(val name: String, val price: Int, val description: String)

data class Table(val num: Int, val seats: Int, val restorant: Restorant?, val reserved: Boolean, val reservation: Reservation?)

data class Reservation(val table: Table, val data: Int, val user: User)
package com.example.tableforyou.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tableforyou.Data.Reservation
import com.example.tableforyou.Data.UTENTIDADB
import com.example.tableforyou.Elements.UpBar
import com.example.tableforyou.Navigation.Home


@Composable
fun ReservationsScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        UpBar(titolo = "Reservations", back = false , onBackClicked ={} , dest = Home)
        ReservationColumn()
    }

}

@Composable
fun ReservationColumn(){
    Reservations(UTENTIDADB.reservations)
    //Reservations(reservations = Users.list[0].reservations)
}

@Composable
fun Reservations(
    reservations: List<Reservation>,
){
    LazyColumn {
        items(reservations) { reservation ->
            ReservationItem(reservation)

        }

    }
}

@Composable
fun ReservationItem(reservation: Reservation){
    Row(
        //horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            //.height(100.dp)
            .border(width = 0.5.dp, color = Color.Black, shape = RectangleShape)
            .padding(all = 15.dp)
    ){
        Image(
            //painter = painterResource(R.drawable.muzon),
            painter = painterResource(reservation.table.restorantlogo),
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
        Column (
            modifier = Modifier.padding(horizontal = 20.dp)
        ){
            Text(text = reservation.table.restorantname,fontFamily = FontFamily.Serif,fontSize = 20.sp)
            Spacer(modifier = Modifier.padding(all = 5.dp))
            Text(text = "Table${reservation.table.num} - ${reservation.table.seats}seats",fontWeight = FontWeight.Bold)
            Text("reserved for")
            Text(reservation.data,fontWeight = FontWeight.Bold)
            /*
            Text(text = "Pizzeria da ciro")
            Spacer(modifier = Modifier.padding(all = 5.dp))
            Text(text = "Table 4(8seats)")
            Text("reserved for")
            Text("Monday at 21.30")
             */
        }


    }
}
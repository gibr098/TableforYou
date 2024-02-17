package com.example.tableforyou.Elements


//import androidx.compose.ui.tooling.data.EmptyGroup.data
import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.InsertInvitation
import androidx.compose.material.icons.filled.NewReleases
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.tableforyou.Data.MyData
import com.example.tableforyou.Data.Restorant
import com.example.tableforyou.Data.Table
import java.util.Calendar


//var DATA by mutableStateOf("")

@Composable
fun ReservationScreen(
    restorant: Restorant,
    confirmReservation: (Table,String) -> Unit
){

    var DATA by remember {
        mutableStateOf("")
    }

    var view by remember {
        mutableStateOf(true)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {

        //tab = TabledropdownMenu(restorant,DATA,restorant.tables)

        if(view) {
            DATA = DateTimePickerComponent(restorant,changeView = {view = false})
        }else{
            TabledropdownMenu(restorant,DATA, confirmReservation, restorant.tables, changeView = {view = true})
        }
    }


    //TabledropdownMenu(restorant,DATA,restorant.tables)

    //TableSelection(restorant = restorant, date = DATA, confirmReservation = confirmReservation)

}


@Composable
fun Tables(onClick: ()-> Unit, tables: List<Table>){
    for(table in tables){
        Table(onClick = onClick, table )
    }
}

@Composable
fun Table(onClick: ()-> Unit, table: Table){
    DropdownMenuItem(
        text = {
            Row {
                Text(text = "Table ${table.num} (${table.seats} seats) ")
                if(table.reserved) {
                    Icon(Icons.Rounded.Clear, contentDescription = "taken")
                    Text(text = "Reserved")
                }
            }
        },
        onClick = onClick,
        enabled = !table.reserved
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabledropdownMenu(
    restorant: Restorant,
    data: String,
    confirmReservation: (Table,String) -> Unit,
    tables: List<Table>,
    changeView: () -> Unit
){
    var isExpanded by remember {
        mutableStateOf(false)
    }

    var tablen by remember {
        mutableStateOf("")
    }

    var tab by remember {
        mutableStateOf(Table())
    }

    var showReservationResult by remember { mutableStateOf(false) }
    var confirmed by remember { mutableStateOf(true) }
    var tableSelected by remember { mutableStateOf(false)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { newValue ->
                isExpanded = newValue
            },
        ) {
            TextField(
                value = tablen,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                placeholder = {
                    Text(text = "Please select your table")
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = {
                    isExpanded = false
                }
            ) {
                //Tables(onClick = { table = "Table"; isExpanded = false}, PizzeriaTables.list)
                for (table in tables) {
                    //Table(onClick = onClick, table )

                    DropdownMenuItem(
                        text = {
                            Row {
                                Text(text = "Table ${table.num} (${table.seats} seats) ")
                                if (table.reserved) {
                                    Icon(Icons.Rounded.Clear, contentDescription = "taken")
                                    Text(text = "Reserved")
                                }
                            }
                        },
                        onClick = {
                            tablen = "Table ${table.num}(${table.seats} seats)";
                            isExpanded = false
                            tableSelected = true
                            for (t in restorant.tables) {
                                if (t.num == table.num) {
                                    tab = table
                                }
                                /*
                            for (e in t.reservations){
                                if(e.resData == DATA){
                                    table.reserved = true
                                    MyData().writeRestorant(restorant,restorant.name)
                                }
                            }*/

                            }
                        },
                        enabled = !table.reserved
                    )
                }

                /*
            DropdownMenuItem(
                text = {
                    Text(text = "Table (4 seats)")
                },
                onClick = {
                    tablen = "Table (4 seats)"
                    isExpanded = false
                }
            )*/
            }
        }
        if (tableSelected) {
            //DATA = "$date At $time"
            Spacer(modifier = Modifier.padding(all = 30.dp))
            Button(
                onClick = { showReservationResult = true; confirmReservation(tab, data);  }, // =true}
                //onClick = { confirmReservation(tab,"$date At $time"); showReservationResult = true; DATA = "" },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp),
                //colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text(text = "Confirm")
            }
            if (showReservationResult) {
                if (confirmed) {
                    ReservationResultDialog(
                        onConfirmation = { showReservationResult = false; changeView()},
                    )
                } else {
                    ReservationResultDialog2(
                        onConfirmation = { showReservationResult = false },
                    )
                }
            }
        }
    }

}


@SuppressLint("SimpleDateFormat")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTimePickerComponent(
    //tab: Table,
    //confirmReservation: (Table,String)-> Unit
    restorant: Restorant,
    changeView: () -> Unit
): String{
    val datePickerState = rememberDatePickerState()
    var showDatePicker by remember { mutableStateOf(false) }
    //var showReservationResult by remember { mutableStateOf(false) }

    //var confirmed by remember { mutableStateOf(true) }

    val timePickerState = rememberTimePickerState(is24Hour = true)
    var showTimePicker by remember { mutableStateOf(false) }

    var dateSelected by remember { mutableStateOf(false) }
    var timeSelected by remember { mutableStateOf(false) }

    var date by remember { mutableStateOf("No Date Selected") }
    var time by remember { mutableStateOf(" No Time Selected") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center,
    ) {
        //TabledropdownMenu()

        Spacer(modifier = Modifier.padding(all = 10.dp))

                Text(text = "$date At $time", modifier = Modifier.padding(bottom = 16.dp))

                Button(
                    onClick = {
                        showDatePicker = true
                    },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(text = "Select Date")
                }


         //Text(text = time, modifier = Modifier.padding(bottom = 16.dp))

                Button(
                    onClick = {
                        showTimePicker = true
                    },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(text = "Select Time")
                }


        Divider(modifier = Modifier.padding(vertical = 24.dp))
        //Spacer(modifier = Modifier.padding(all = 20.dp))

        if (dateSelected and timeSelected) {
            //DATA = "$date At $time"
            Button(
                onClick = {
                    changeView()
                    for(t in restorant.tables){
                        for(r in t.reservations){
                            if (r.resData == ("$date At $time")){
                                t.reserved=true
                                MyData().writeRestorant(restorant,restorant.name)
                            }else{
                                t.reserved=false
                                MyData().writeRestorant(restorant,restorant.name)
                            }
                        }
                    }
                          },
                //onClick = { confirmReservation(tab,"$date At $time"); showReservationResult = true; DATA = "" },
                modifier = Modifier.fillMaxWidth(),
                //colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text(text = "Confirm")
            }

        }

    }

    // date picker component
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { /*TODO*/ },
            confirmButton = {
                TextButton(
                    onClick = {
                        val selectedDate = Calendar.getInstance().apply {
                            timeInMillis = datePickerState.selectedDateMillis!!
                        }
                        val simpleDateFormat = SimpleDateFormat(" EEEE dd.MM.yyyy")
                        val dateTime = simpleDateFormat.format(selectedDate.time).toString()
                        showDatePicker = false
                        date = dateTime
                        dateSelected = true
                    }
                ) { Text("OK") }
                            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDatePicker = false
                    }
                ) { Text("Cancel") }
            }
        )
        {
            DatePicker(state = datePickerState)
        }
    }


// time picker component
    if (showTimePicker) {
        TimePickerDialog(
            onDismissRequest = { /*TODO*/ },
            confirmButton = {
                TextButton(
                    onClick = {
                        showTimePicker = false
                        time = "${timePickerState.hour}:${timePickerState.minute}"
                        timeSelected = true
                    }
                ) { Text("OK") }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showTimePicker = false
                    }
                ) { Text("Cancel") }
            }
        )
        {
            TimePicker(state = timePickerState)

        }
    }
    return "$date At $time"


}
@Composable
fun TimePickerDialog(
    title: String = "Select Time",
    onDismissRequest: () -> Unit,
    confirmButton: @Composable (() -> Unit),
    dismissButton: @Composable (() -> Unit)? = null,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        Surface(
            shape = MaterialTheme.shapes.extraLarge,
            tonalElevation = 6.dp,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
                .background(
                    shape = MaterialTheme.shapes.extraLarge,
                    color = containerColor
                ),
            color = containerColor
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    text = title,
                    style = MaterialTheme.typography.labelMedium
                )
                content()
                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    dismissButton?.invoke()
                    confirmButton()
                }
            }
        }
    }
}

@Composable
fun ReservationResultDialog(
    onConfirmation: () -> Unit
){
                AlertDialogExample(
                    onDismissRequest = { },
                    onConfirmation = onConfirmation,
                    dialogTitle = "Table Reserved!",
                    dialogText = "Thank you! Your reservation has been registered, you can find it in the" +
                            "Reservation section",
                    icon = Icons.Default.InsertInvitation
                )
            }
@Composable
fun ReservationResultDialog2(
    onConfirmation: () -> Unit
){
    AlertDialogExample(
        onDismissRequest = { },
        onConfirmation = onConfirmation,
        dialogTitle = "Please Select a Table",
        dialogText = "",
        icon = Icons.Default.NewReleases
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("")
            }
        }
    )
}




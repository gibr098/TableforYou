package com.example.tableforyou.Elements


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
import androidx.compose.material.icons.rounded.Clear
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.tableforyou.Data.Restorant
import com.example.tableforyou.Data.Table
import java.util.Calendar



@Composable
fun ReservationScreen(restorant: Restorant){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {

        TabledropdownMenu(restorant.tables)
    }
        DateTimePickerComponent()

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
fun TabledropdownMenu(tables: List<Table>) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    var tablen by remember {
        mutableStateOf("")
    }

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
            for(table in tables){
                //Table(onClick = onClick, table )
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
                    onClick = { tablen = "Table ${table.num}(${table.seats} seats)"; isExpanded = false},
                    enabled = !table.reserved
                )
            }

            DropdownMenuItem(
                text = {
                    Text(text = "Table (4 seats)")
                },
                onClick = {
                    tablen = "Table (4 seats)"
                    isExpanded = false
                }
            )
        }
    }
}


@SuppressLint("SimpleDateFormat")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTimePickerComponent() {
    val datePickerState = rememberDatePickerState()
    var showDatePicker by remember { mutableStateOf(false) }

    val timePickerState = rememberTimePickerState(is24Hour = true)
    var showTimePicker by remember { mutableStateOf(false) }

    var dateSelected by remember { mutableStateOf(false) }
    var timeSelected by remember { mutableStateOf(false) }

    var date by remember { mutableStateOf("No Date Selected") }
    var time by remember { mutableStateOf(" No Time Selected") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
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
            Button(
                onClick = { },
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

package com.scifre.attendit.components.dayTextBox

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable()
@Preview(showBackground = true)
fun TimePickerDialog(
    onDismissRequest: () -> Unit = {},
    onConfirmRequest: () -> Unit = {},
    timePickerState: TimePickerState = rememberTimePickerState(),
    whichTime: String = "Start Time"
){

    BasicAlertDialog(
        onDismissRequest = { onDismissRequest() }
    ) {
        Card(
            modifier = Modifier,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ){
                Text(
                    text = "Select $whichTime",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                )
                Spacer(modifier = Modifier.size(20.dp))
                TimePicker(
                    modifier = Modifier,
                    state = timePickerState
                )
                Spacer(Modifier.size(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = {onDismissRequest()},
                        modifier = Modifier
                            .padding(4.dp)
                    ){
                        Text(
                            text = "Cancel",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(4.dp)
                        )
                    }
                    TextButton(
                        onClick = {onConfirmRequest()},
                        modifier = Modifier
                            .padding(4.dp)
                    ){
                        Text(
                            text = "OK",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(4.dp)
                        )
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AddClass(
    onAddClassPressed: (String, String, String) -> Unit = { _, _, _ -> },
){

    var isDropdownMenuExpanded by remember { mutableStateOf(false) }
    val days = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    var selectedDay by remember { mutableStateOf("") }
    var isSelectDayFocused by remember { mutableStateOf(false) }
    val startTimeState = rememberTimePickerState()
    val endTimeState = rememberTimePickerState()
    var startTime = formatTo12Hour(startTimeState.hour, startTimeState.minute, startTimeState.isAfternoon)
    var endTime = formatTo12Hour(endTimeState.hour, endTimeState.minute, endTimeState.isAfternoon)
    var showTimeDialog by remember { mutableStateOf(false) }
    var useState by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            /*.background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(8.dp)
            )*/
            .padding(4.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Select Day",
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(0.4f)
            )
            ExposedDropdownMenuBox(
                expanded = isDropdownMenuExpanded,
                onExpandedChange = {
                    isDropdownMenuExpanded = !isDropdownMenuExpanded
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.6f)

                ) {
                OutlinedTextField(
                    value = selectedDay,
                    textStyle = TextStyle(
                        fontSize = 20.sp
                    ),
                    placeholder = {
                        Text(
                            text = "Select Day",
                            fontSize = 20.sp
                        )
                    },
                    onValueChange = {
                        selectedDay = it
                    },
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDropdownMenuExpanded)
                    },
                    modifier = Modifier
                        .menuAnchor()

                )

                ExposedDropdownMenu(
                    expanded = isDropdownMenuExpanded,
                    onDismissRequest = {
                        isDropdownMenuExpanded = false
                    },

                    ) {
                    days.forEach { day ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = day,
                                    fontSize = 20.sp
                                )
                            },
                            onClick = {
                                selectedDay = day
                                isDropdownMenuExpanded = false
                            }
                        )
                    }
                }
            }


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Start Time",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .weight(0.4f)
            )

            Row(
                modifier = Modifier
                    .weight(0.6f)
            ){
                Box(
                    modifier = Modifier
                        .wrapContentWidth()
                        .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(4.dp))
                ){
                    Text(
                        text = startTime,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable(
                                onClick = {
                                    println("Start Time Clicked")
                                    useState = "Start Time"
                                    showTimeDialog = true
                                }
                            )

                    )
                }
            }


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "End Time",
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(0.4f)
            )

            Row(
                modifier = Modifier
                    .weight(0.6f)
            ){
                Box(
                    modifier = Modifier
                        .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(4.dp))
                ){
                    Text(
                        text = endTime,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable(
                                onClick = {
                                    println("End Time Clicked")
                                    useState = "End Time"
                                    showTimeDialog = true
                                }
                            )

                    )
                }
            }
        }

        Button(
            onClick = {
                onAddClassPressed(
                    selectedDay,
                    String.format(Locale.getDefault(), "%02d:%02d", startTimeState.hour, startTimeState.minute),
                    String.format(Locale.getDefault(), "%02d:%02d", endTimeState.hour, endTimeState.minute)
                )
                startTimeState.hour = 0
                startTimeState.minute = 0
                endTimeState.hour = 0
                endTimeState.hour = 0
                selectedDay = ""

            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(4.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Add Class",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(4.dp)
            )
        }


    }
    if(showTimeDialog){
        TimePickerDialog(
            onConfirmRequest = {
                showTimeDialog = false
            },
            onDismissRequest = {
                showTimeDialog = false
                if(useState == "End Time") {
                    endTimeState.hour = 0
                    endTimeState.minute = 0
                }
                else{
                    startTimeState.hour = 0
                    startTimeState.minute = 0
                }
            },
            timePickerState = if(useState == "Start Time") startTimeState else endTimeState,
            whichTime = useState
        )
    }

}

fun formatTo12Hour(hour: Int, minute: Int, isAfternoon: Boolean): String {
    val h = if (hour == 0) {
        12
    } else if (hour > 12) {
        hour - 12
    } else {
        hour
    }
    val period = if (isAfternoon) "PM" else "AM"
    return String.format(Locale.getDefault(), "%02d:%02d %s", h, minute, period)
}
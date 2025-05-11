package com.scifre.attendit.components.scheduleBox

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Import Icon composable



@Preview(showBackground = true)
@Composable
fun ScheduleBox(
    modifier: Modifier = Modifier,
    scheduleList: List<List<String>> = remember { (mutableListOf<List<String>>(listOf("Saturday", "11:00", "12:00")))},
    onDeletePressed: (Int) -> Unit = {}

){
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ){
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 8.dp),

            ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            ){
                Text(
                    text = "#",
                    fontSize = 15.sp,
                    fontWeight = Bold,
                    modifier = Modifier.weight(0.2f)
                )
                Text(
                    text = "Day",
                    fontSize = 15.sp,
                    fontWeight = Bold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Start Time",
                    fontSize = 15.sp,
                    fontWeight = Bold,
                    modifier = Modifier.weight(0.7f)
                )
                Text(
                    text = "End Time",
                    fontSize = 15.sp,
                    fontWeight = Bold,
                    modifier = Modifier.weight(0.7f)
                )
                Box(
                    modifier = Modifier.weight(0.2f)
                )

            }
            if(scheduleList.isNotEmpty()){
                scheduleList.forEachIndexed { index, schedule->

                    Row(
                        modifier = Modifier.
                        fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "${index + 1}.",
                            fontSize = 20.sp,
                            modifier = Modifier.weight(0.2f)
                        )
                        Text(
                            text = schedule[0],
                            fontSize = 20.sp,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = schedule[1],
                            fontSize = 20.sp,
                            modifier = Modifier.weight(0.7f)
                        )
                        Text(
                            text = schedule[2],
                            fontSize = 20.sp,
                            modifier = Modifier.weight(0.7f)
                        )
                        IconButton(
                            onClick = {onDeletePressed(index)},
                            modifier = Modifier.weight(0.2f).size(35.dp)
                        ){
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete",
                                modifier = Modifier.size(25.dp)
                            )
                        }
                    }
                }
            }
            else{
                Text(
                    text = "No Schedule Added",
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
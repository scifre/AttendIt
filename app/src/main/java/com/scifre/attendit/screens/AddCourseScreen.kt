package com.scifre.attendit.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.scifre.attendit.components.dayTextBox.AddClass
import com.scifre.attendit.components.scheduleBox.ScheduleBox


@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCourseScreen(
    //viewModel: AddCourseViewModel = hiltViewModel()
) {
    var scheduleList = remember { (mutableStateListOf<List<String>>(listOf("Wednesday", "11:00", "12:00"), listOf("Saturday", "9:00", "12:00"))) }

    fun onDeletePressed(index: Int) {
        scheduleList.removeAt(index)
    }
    fun onAddClassPressed(day: String, startTime: String, endTime: String) {
        scheduleList.add(listOf(day, startTime, endTime))
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Add Course",
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        },
        content = {
            paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(all = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(
                            text = "Course Name",
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                )
                Spacer(Modifier.size(10.dp))
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(
                            text = "Faculty Name",
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                )
                Spacer(Modifier.size(10.dp))
                Text(
                    text = "Course Schedule",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(4.dp)

                )

                ScheduleBox(
                    modifier = Modifier,
                    scheduleList = scheduleList,
                    onDeletePressed = {index->
                        onDeletePressed(index)
                    }
                )
                Spacer(Modifier.size(20.dp))
                Text(
                    text = "Add New Class",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(4.dp)
                )
                AddClass(
                    onAddClassPressed = {day, startTime, endTime ->
                        onAddClassPressed(day, startTime, endTime)
                    }

                )


            }
        }
    )

}



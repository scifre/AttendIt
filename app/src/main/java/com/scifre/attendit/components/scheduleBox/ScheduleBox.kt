package com.scifre.attendit.components.scheduleBox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun ScheduleBox(
    day: String = "Monday",
){
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primaryContainer),
    ){
        Text(
            text = day,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.size(20.dp))

        var numberOfClasses = 5

        var Classes = remember{ mutableMapOf<Int, Int>(1, 2) }

        Button(
            onClick = {}
        ) {
            Text(
                text = "Add Class"
            )
        }

    }
}
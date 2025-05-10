package com.scifre.attendit.components.dayTextBox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//import Row


@Preview(showBackground = true)
@Composable
fun Day(day: String = "Monday"){
    TextButton(
        onClick = {},
        contentPadding = PaddingValues(vertical = 0.dp),
        //write code to match parent size

        modifier = Modifier.height(IntrinsicSize.Min),
        content = {
            Text(
                day,
                fontSize = 20.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier
            )
        }
    )
}
@Preview(showBackground = true)
@Composable
fun AddClassTime(index: Int = 1){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "$index.",
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontSize = 20.sp
        )
        Text(
            text = "From: ",
            fontSize = 20.sp

        )
        TextField(
            value = "00:00",
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            ),
            placeholder = {
                Text(
                    text = "HH:MM",
                    fontSize = 16.sp,
                    //modifier = Modifier.wrapContentSize()

                )
            },
            onValueChange = {},
            modifier = Modifier.width(90.dp)
        )
        Text(
            text = "To",
            fontSize = 20.sp
        )
        TextField(
            value = "00:00",
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 23.sp
            ),
            placeholder = {
                Text(
                    text = "HH:MM",
                    fontSize = 16.sp,
                    //modifier = Modifier.wrapContentSize()

                )
            },
            onValueChange = {},
            modifier = Modifier.width(90.dp)
        )

    }
}
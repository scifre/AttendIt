package com.scifre.attendit.dayTextBox

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Day(day: String = "Monday"){
    TextButton(
        onClick = {},
        contentPadding = PaddingValues(vertical = 0.dp),
        //write code to match parent size

        modifier = Modifier.height(IntrinsicSize.Min).fillMaxWidth(),
        content = {
            Text(
                day,
                fontSize = 20.sp,
                //modifier = Modifier.align(Alignment.Start)
            )
        }
    )
}
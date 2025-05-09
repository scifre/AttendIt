package com.scifre.attendit.components.attendanceBox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.scifre.attendit.ui.theme.AttendanceBoxLightGreen
import com.scifre.attendit.ui.theme.AttendanceBoxLightRed

@Preview
@Composable
fun AttendanceBoxScreen(
    modifier: Modifier = Modifier,
    type: String = "Absent"
) {
    val bottomTextColor = when(type) {
        "Present" -> Color(0xff0bb302)
        "Absent" -> Red
        "Cancelled" -> DarkGray
        else -> White
    }
    val bottomCardColor = when(type) {
        "Present" -> AttendanceBoxLightGreen
        "Absent" -> AttendanceBoxLightRed
        "Cancelled" -> LightGray
        else -> White
    }
    Card(
        modifier = modifier
            .width(80.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(8.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = bottomCardColor
        ),
        shape = RoundedCornerShape(8.dp),
    ) {


        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)

        ) {
            Box(modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primary)
                .padding(5.dp)
                .fillMaxWidth()
            ){
                Text(
                    text = type,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 15.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Box(modifier = Modifier
                .padding(5.dp)
                .align(Alignment.CenterHorizontally)
            ){
                Text(
                    text = "21",
                    color = bottomTextColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}
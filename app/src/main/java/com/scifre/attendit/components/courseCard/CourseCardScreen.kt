package com.scifre.attendit.components.courseCard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.himanshoe.charty.circle.CircleChart
import com.himanshoe.charty.circle.config.CircleChartConfig
import com.himanshoe.charty.circle.model.CircleData
import com.himanshoe.charty.circle.model.StartingPosition
import com.himanshoe.charty.common.ChartColor
import com.scifre.attendit.components.attendanceBox.AttendanceBoxScreen

@Preview(showBackground = true)
@Composable
fun CourseCard(
    //viewModel: CourseCardViewModel = hiltViewModel()
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = RoundedCornerShape(8.dp),

    ) {
        Box {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Row {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = "Course Name",
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            modifier = Modifier
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            text = "Faculty Name",
                            fontSize = 15.sp,
                            color = DarkGray,
                            modifier = Modifier
                        )
                    }


                    IconButton(
                        modifier = Modifier.size(30.dp),
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Arrow Down",
                            modifier = Modifier.fillMaxSize(),

                            )
                    }
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row(
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    val circleData = listOf(
                        CircleData(80f, ChartColor.Solid(Red), label = "A"),
                        CircleData(0f, ChartColor.Solid(LightGray), label = "C"),
                        CircleData(0f, ChartColor.Solid(LightGray), label = "B")
                    )
                    val circleChartConfig = CircleChartConfig(
                        showEndIndicator = false,
                        startingPosition = StartingPosition.Top
                    )

                    AttendanceBoxScreen(type = "Present", modifier = Modifier)
                    //Spacer(modifier = Modifier.weight(1f))
                    AttendanceBoxScreen(Modifier, "Absent")
                    //Spacer(modifier = Modifier.weight(1f))
                    AttendanceBoxScreen(Modifier, "Cancelled")
                    ///Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier//.weight(1f)
                    ) {

                        CircleChart(
                            circleChartConfig = circleChartConfig,
                            data = { circleData },
                            modifier = Modifier.size(80.dp),
                            onCircleClick = {},
                        )
                        Text(
                            text = "75%",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .background(color = LightGray),
                            color = Red,
                            fontSize = 20.sp

                        )
                    }


                }

            }
        }


    }
}


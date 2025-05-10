package com.scifre.attendit.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.scifre.attendit.components.courseCard.CourseCard
import com.scifre.attendit.navigation.navGraph

@Preview(showBackground = true)
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScreen(
    navController: NavHostController
    //viewModel: HomeScreenViewModel = hiltViewModel()
){

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Attend-It",
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                )
            )
        },

        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { navController.navigate("addCourse") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                content = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Course",
                        modifier = Modifier.size(25.dp)
                    )
                    Text(
                        text = "Add Course",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 5.dp)

                    )
                }
            )
            
        },
        content = {paddingValues ->
            LazyColumn(
                modifier = Modifier.padding(paddingValues).padding(all = 8.dp)
            ){
                item{
                    CourseCard()
                }
            }
        }
    )
}

package com.scifre.attendit

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.scifre.attendit.navigation.navGraph
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navGraph()
        }
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            Log.e("wer", "Thread: $thread", throwable)
        }
    }
}

@HiltAndroidApp
class AttendItApplication : Application() {

}

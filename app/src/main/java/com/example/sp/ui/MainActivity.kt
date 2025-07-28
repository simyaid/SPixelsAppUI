package com.example.sp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.sp.ui.screens.SplashScreen
import com.example.sp.ui.theme.SPtheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SPtheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    SplashScreen(onGetStartedClick = {
                        // TODO: Navigate later
                    })
                }
            }
        }
    }
}

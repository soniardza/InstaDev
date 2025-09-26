package com.soniadevs.instadev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.soniadevs.instadev.ui.theme.InstaDevTheme
import com.soniadevs.instadev.view.core.navigation.NavigationWrapper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstaDevTheme {
                NavigationWrapper()
            }
        }
    }
}


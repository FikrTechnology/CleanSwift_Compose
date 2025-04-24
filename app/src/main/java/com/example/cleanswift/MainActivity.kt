package com.example.cleanswift

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cleanswift.navigation.SetupNavigation
import com.example.cleanswift.ui.theme.CleanSwiftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CleanSwiftTheme {
                SetupNavigation()
            }
        }
    }
}
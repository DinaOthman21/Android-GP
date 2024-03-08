package com.example.androidproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidproject.presentation.HomeActivity
import com.example.androidproject.presentation.components.SplashScreen
import com.example.androidproject.ui.theme.AndroidProjectTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidProjectTheme {
                SplashScreen()
                LaunchedEffect(Unit) {
                    delay(2000)

                    val intent = Intent(this@MainActivity,HomeActivity::class.java)

                    startActivity(intent)

                    finish()
                }
            }
        }
    }
}


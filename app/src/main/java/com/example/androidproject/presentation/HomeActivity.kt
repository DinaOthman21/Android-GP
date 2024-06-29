package com.example.androidproject.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.androidproject.presentation.auth.login.LoginScreenViewModel
import com.example.androidproject.ui.theme.AndroidProjectTheme
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.androidproject.presentation.navigation.AppNavigation

class HomeActivity : ComponentActivity(){
    private val loginViewModel by viewModels<LoginScreenViewModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(loginViewModel = loginViewModel )
                }

            }
        }
    }
}


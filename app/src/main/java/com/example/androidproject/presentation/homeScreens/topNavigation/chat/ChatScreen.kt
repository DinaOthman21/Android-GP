package com.example.androidproject.presentation.homeScreens.topNavigation.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ChatScreen(navController: NavHostController){
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier=Modifier.fillMaxSize().align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text="Chat", fontSize = 18.sp, style = TextStyle(color = Color.Blue))

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatPreview() {
    val navController = rememberNavController()
    ChatScreen(navController)
}
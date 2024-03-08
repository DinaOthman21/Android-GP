package com.example.androidproject.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidproject.presentation.auth.LoginScreen
import com.example.androidproject.presentation.auth.LoginScreenViewModel


@Composable
fun AppNavigation(loginViewModel: LoginScreenViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Login.route){
        composable(route = Screens.Login.route){
            LoginScreen(loginViewModel = loginViewModel)
        }

        composable(route = Screens.Home.route){
        }

        composable(route = Screens.PostDetails.route){
        }

    }
}
package com.example.androidproject.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidproject.presentation.auth.LoginScreen
import com.example.androidproject.presentation.auth.LoginScreenViewModel
import com.example.androidproject.presentation.components.Post
import com.example.androidproject.presentation.homeScreens.HomeScreen
import com.example.androidproject.presentation.homeScreens.PostDetails


@Composable
fun AppNavigation(loginViewModel: LoginScreenViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Login.route){
        composable(route = Screens.Login.route){
            LoginScreen(loginViewModel = loginViewModel,navController = navController)
        }

        composable(route = Screens.Home.route){
            HomeScreen(navController = navController)
        }

        composable(route = Screens.PostDetails.route){

            // Post Details screen
            val post: Post? = navController
                .previousBackStackEntry
                ?.savedStateHandle?.get("post")

            post?.let {
                PostDetails(post = it,navController = navController)
            }
        }

    }
}
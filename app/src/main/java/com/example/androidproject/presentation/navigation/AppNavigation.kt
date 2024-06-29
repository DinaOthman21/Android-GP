package com.example.androidproject.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidproject.data.remote.dto.Post
import com.example.androidproject.presentation.auth.login.LoginScreen
import com.example.androidproject.presentation.auth.login.LoginScreenViewModel
import com.example.androidproject.presentation.homeScreens.bottomNavigation.home.HomeScreen
import com.example.androidproject.presentation.homeScreens.bottomNavigation.home.PostDetails


@Composable
fun AppNavigation(
    loginViewModel: LoginScreenViewModel,
   // signUpScreenViewModel : SignUpScreenViewModel
    )
{
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

        composable(route = Screens.SignUp.route){

         //  SignUpScreen(navController = navController,signUpScreenViewModel = signUpScreenViewModel)
        }



    }
}
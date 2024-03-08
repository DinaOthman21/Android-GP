package com.example.androidproject.presentation.navigation

sealed class Screens(val route:String){
    data object Login : Screens(route = "login")
    data object Home : Screens(route = "home")
    data object PostDetails : Screens(route = "postDetails")


}
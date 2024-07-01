package com.example.androidproject.presentation.navigation

sealed class Screens(val route:String){
    data object Login : Screens(route = "login")
    data object Home : Screens(route = "home")
    data object PostDetails : Screens(route = "postDetails")
    data object SignUp : Screens(route = "signUp")
    data object Prediction : Screens(route = "prediction")
    data object Medicine : Screens(route = "medicine")
    data object Calculator : Screens(route = "calculator")
    data object Chat : Screens(route = "chat")
    data object Information : Screens(route = "information")



}
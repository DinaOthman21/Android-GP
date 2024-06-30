package com.example.androidproject.presentation.homeScreens.BottomAppBar

import androidx.annotation.DrawableRes
import com.example.androidproject.R

sealed class BottomBarItem(
    @DrawableRes val icon: Int,
    val text: String ,
    val route: String,
) {
    object Home : BottomBarItem(
        icon=  R.drawable.home ,
        text = "Home",
        route = "home",

    )

    object Prediction : BottomBarItem(
        icon=  R.drawable.prediction ,
        text = "Prediction",
        route = "prediction",

        )

    object Medicine : BottomBarItem(
        icon=  R.drawable.medicine ,
        text = "Drug",
        route = "medicine",

        )

    object Calculator : BottomBarItem(
        icon=  R.drawable.calculator ,
        text = "Calculator",
        route = "calculator",

        )
}
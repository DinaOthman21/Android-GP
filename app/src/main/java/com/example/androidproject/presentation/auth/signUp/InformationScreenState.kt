package com.example.androidproject.presentation.auth.signUp

data class InformationScreenState(
    val height:String = "",
    val isErrorHeight:Boolean = false,
    val heightErrorMessage:String = "",

    val weight:String = "",
    val isErrorWeight:Boolean = false,
    val weightErrorMessage:String = "",

    val age:String = "",
    val isErrorAge:Boolean = false,
    val ageErrorMessage:String = "",



    val male:Boolean = false,
    val female:Boolean = false,
    val genderErrorMessage:String = "",


    val errorMessage:String = "",
)

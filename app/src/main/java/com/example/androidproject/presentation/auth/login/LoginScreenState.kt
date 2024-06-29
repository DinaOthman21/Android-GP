package com.example.androidproject.presentation.auth.login




data class LoginScreenState(
    val email:String = "",
    val isEmailError:Boolean = false,
    val errorMessageEmail:String = "",

    val password:String = "",
    val isPasswordError:Boolean = false,
    val errorMessagePassword:String = "",
    val showPassword:Boolean = false,


    val checkBoxState:Boolean = false,

    )
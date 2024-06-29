package com.example.androidproject.presentation.auth.login

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.navigation.NavHostController
import com.example.androidproject.R
import com.example.androidproject.presentation.navigation.Screens

class LoginScreenViewModel :ViewModel() {
    private var _state by mutableStateOf(
        LoginScreenState()
    )

    val state: State<LoginScreenState>
        get() = derivedStateOf { _state }

    fun onEmailChange(email:String){
        _state = _state.copy(
            email = email,
            isEmailError = false,
            errorMessageEmail = ""
        )
    }

    fun onPasswordChange(password:String){
        _state = _state.copy(
            password = password,
            isPasswordError = false,
            errorMessagePassword = ""
        )
    }

    // when user need to make password is visible
    fun onIconShowPassword(){
        val newShowPassword = _state.showPassword.not()
        _state = _state.copy(
            showPassword = newShowPassword
        )
    }

    fun onRememberMeClick(){
        val newRememberMe = _state.checkBoxState.not()
        _state = _state.copy(
            checkBoxState = newRememberMe
        )
    }


    // user click on button to login
    // make check in data and then call login endpoint
    // to get token
    fun onLoginClick(context: Context, navController: NavHostController){
        if (_state.email.isEmpty()){
            _state=_state.copy(
                isEmailError = true,
                errorMessageEmail = context.getString(R.string.please_enter_your_email)
            )

        }
        if (isValidEmail(_state.email).not()){
            _state=_state.copy(
                isEmailError = true,
                errorMessageEmail = context.getString(R.string.please_enter_valid_email)
            )

        }
        if (_state.password.isEmpty()){
            _state=_state.copy(
                isPasswordError = true,
                errorMessagePassword = context.getString(R.string.please_enter_your_password)
            )

        }

        if (_state.password.isNotEmpty() && _state.email.isNotEmpty() && isValidEmail(_state.email)){

            // save token as example to save user if user make Remember me true
            navController.navigate(Screens.Home.route){
                popUpTo(Screens.Login.route) {
                    inclusive = true
                }
            }
        }

    }




    private fun isValidEmail(email: String): Boolean {
        // Regular expression pattern to validate the email format
        val pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        // Check if the provided email matches the pattern
        return email.matches(Regex(pattern))
    }


}
package com.example.androidproject.presentation.auth.signUp

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.androidproject.R
import com.example.androidproject.presentation.navigation.Screens


class SignUpScreenViewModel: ViewModel()
{

    private var _state by mutableStateOf(
        SignUpScreenState()
    )


    val state: State<SignUpScreenState>
        get() = derivedStateOf { _state }

    fun onIconShowPassword(){
        val newShowPassword = _state.showPassword.not()
        _state = _state.copy(
            showPassword = newShowPassword
        )
    }


    fun onIconShowConfirmPassword(){
        val newShowConfirmPassword = _state.showConfirmPassword.not()
        _state = _state.copy(
            showConfirmPassword = newShowConfirmPassword
        )
    }


    fun onUserNameChange(userName:String){
        _state = _state.copy(
            userName = userName,
            isErrorEmail  = false,
            userNameErrorMessage = "",
            errorMessage = ""
        )
    }

    fun onEmailChange(email:String){
        _state = _state.copy(
            email = email,
            isErrorEmail  = false,
            emailErrorMessage = "",
            errorMessage = ""
        )
    }

    fun onPasswordChange(password:String){
        _state = _state.copy(
            password = password,
            isErrorPassword = false,
            passwordErrorMessage = "",
            errorMessage = ""
        )

    }

    fun onConfirmPasswordChange(password:String){
        _state = _state.copy(
            confirmPassword = password,
            isErrorConfirmPassword  = false,
            confirmPasswordErrorMessage = "",
            errorMessage = ""
        )

    }

    fun onNextToSecondScreen(navController: NavHostController, context: Context){
        if (_state.userName.isEmpty()){
            _state=_state.copy(
                isErrorUserName = true,
                userNameErrorMessage = context.getString(R.string.please_enter_your_name)
            )

        }

        if (_state.email.isEmpty()){
            _state=_state.copy(
                isErrorEmail = true,
                emailErrorMessage = context.getString(R.string.please_enter_your_email)
            )

        }
        if (isValidEmail(_state.email).not()){
            _state=_state.copy(
                isErrorEmail = true,
                emailErrorMessage = context.getString(R.string.please_enter_valid_email)
            )

        }

        if (_state.password.isEmpty()){
            _state=_state.copy(
                isErrorPassword = true,
                passwordErrorMessage = context.getString(R.string.please_enter_your_password)
            )

        }

        if (_state.confirmPassword.isEmpty()){
            _state=_state.copy(
                isErrorConfirmPassword = true,
                confirmPasswordErrorMessage = context.getString(R.string.please_enter_confirm_password)
            )

        }

        if (_state.confirmPassword != _state.password ){
            _state=_state.copy(
                isErrorConfirmPassword = true,
                confirmPasswordErrorMessage = context.getString(R.string.confirm_password_not_match_password)
            )

        }

        if (!isValidPassword(_state.password)){
            _state=_state.copy(
                isErrorPassword = true,
                passwordErrorMessage = context.getString(R.string.password_length_error_message)
            )

        }

        if (_state.userName.isNotEmpty() &&
            _state.password.isNotEmpty() &&
            _state.confirmPassword.isNotEmpty() &&
            _state.email.isNotEmpty() &&
            isValidEmail(_state.email) &&
            _state.confirmPassword == _state.password &&
            isValidPassword(_state.password)
        ){
            navController.navigate(Screens.Information.route)
        }

    }


    private fun isValidEmail(email: String): Boolean {
        // Regular expression pattern to validate the email format
        val pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        // Check if the provided email matches the pattern
        return email.matches(Regex(pattern))
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 8
    }


}
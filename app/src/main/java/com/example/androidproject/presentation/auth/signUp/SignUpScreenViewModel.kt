package com.example.androidproject.presentation.auth.signUp

import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel



class SignUpScreenViewModel: ViewModel()
{

    private var _state by mutableStateOf(
        SignUpScreenState()
    )


    val state: State<SignUpScreenState>
        get() = derivedStateOf { _state }


}
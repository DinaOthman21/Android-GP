package com.example.androidproject.presentation.auth.signUp


import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.androidproject.R
import com.example.androidproject.presentation.navigation.Screens


class InformationScreenViewModel: ViewModel()
{
    private var _state by mutableStateOf(
        InformationScreenState()
    )


    val state: State<InformationScreenState>
        get() = derivedStateOf { _state }



    fun onHeightChange(height: String,context: Context){
        _state = if (height.toDoubleOrNull() != null || height.isEmpty()) {
            _state.copy(
                height = height,
                isErrorHeight = false,
                heightErrorMessage = "",
                errorMessage = ""
            )
        } else{
            _state.copy(
                isErrorHeight = true,
                heightErrorMessage = context.getString(R.string.please_enter_a_valid_height)
            )
        }
    }

    fun onWeightChange(weight: String,context:Context) {
        _state = if (weight.toDoubleOrNull() != null || weight.isEmpty()) {
            _state.copy(
                weight = weight,
                isErrorWeight = false,
                weightErrorMessage = "",
                errorMessage = ""
            )
        } else {
            _state.copy(
                isErrorWeight = true,
                weightErrorMessage = context.getString(R.string.please_enter_a_valid_weight)
            )
        }
    }



    fun onAgeChange(age: String,context:Context) {
        _state = if (age.toIntOrNull() != null || age.isEmpty()) {
            _state.copy(
                age = age,
                isErrorAge = false,
                ageErrorMessage = "",
                errorMessage = ""
            )
        } else {
            _state.copy(
                isErrorAge = true,
                ageErrorMessage = context.getString(R.string.please_enter_a_valid_age),
            )
        }
    }



    fun onGenderSelectMale(){
        val newMaleValue = _state.male.not()
        _state = _state.copy(
            male  = newMaleValue,
            female = newMaleValue.not(),
            genderErrorMessage = "",
            errorMessage = ""
        )
    }


    fun onGenderSelectFemale(){
        val newFemaleValue = _state.female.not()
        _state = _state.copy(
            male  = newFemaleValue.not(),
            female = newFemaleValue,
            genderErrorMessage = "",
            errorMessage = ""
        )
    }

    fun onNextToLastScreen(navController: NavHostController, context: Context){
        if (_state.height.isEmpty()){
            _state=_state.copy(
                isErrorHeight = true,
                heightErrorMessage = context.getString(R.string.please_enter_your_height)
            )
        }
        if (_state.weight.isEmpty()){
            _state=_state.copy(
                isErrorWeight = true,
                weightErrorMessage = context.getString(R.string.please_enter_your_weight)
            )
        }
        if (_state.age.isEmpty()){
            _state=_state.copy(
                isErrorAge = true,
                ageErrorMessage = context.getString(R.string.please_enter_your_age)
            )
        }

        if ( _state.male == _state.female){
            _state=_state.copy(
                genderErrorMessage = context.getString(R.string.please_select_your_gender)
            )
        }

        if (_state.height.isNotEmpty()&&
            _state.weight.isNotEmpty()&&
            _state.age.isNotEmpty()&&
            _state.male == _state.female.not()
        ){
           navController.navigate(Screens.Home.route)

        }
    }








}
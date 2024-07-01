package com.example.androidproject.presentation.auth.signUp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidproject.R
import com.example.androidproject.presentation.components.BackIcon
import com.example.androidproject.presentation.components.ButtonClickOn
import com.example.androidproject.presentation.components.CheckboxWithName
import com.example.androidproject.presentation.components.NumberEditText
import com.example.androidproject.presentation.components.TextLabel

@Composable
fun InformationScreen(navController: NavHostController, informationScreenViewModel: InformationScreenViewModel) {

    val state = informationScreenViewModel.state.value
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(12.dp),
    ) {
        Row(
            modifier = Modifier.padding(bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BackIcon{ navController.popBackStack()}

        }

        TextLabel(
            text = stringResource(R.string.create_new_account),
            modifier = Modifier.padding(top = 10.dp),
            textFont = 28,
            textFontWight = FontWeight.Bold
        )
        TextLabel(
            text = stringResource(R.string.enter_the_required_data_below),
            modifier = Modifier.padding(top = 10.dp),
            textFont = 18,
            textColor = MaterialTheme.colorScheme.secondary
        )


        TextLabel(
            text = stringResource(R.string.height),
            modifier = Modifier.padding(top = 30.dp,bottom = 10.dp),
            textFont = 18,
            textFontWight = FontWeight.Bold
        )

        NumberEditText(
            number = state.height,
            placeholderID = R.string.enter_your_height,
            isNumberError = state.isErrorHeight,
            numberErrorMessage = state.heightErrorMessage,
            onValueChange = {  newValue->
                informationScreenViewModel.onHeightChange(newValue,context)
            }
        )
        TextLabel(
            text = stringResource(R.string.weight),
            modifier = Modifier.padding(bottom = 10.dp),
            textFont = 18,
            textFontWight = FontWeight.Bold
        )
        NumberEditText(
            number = state.weight,
            placeholderID = R.string.enter_your_weight,
            isNumberError = state.isErrorWeight,
            numberErrorMessage = state.weightErrorMessage,
            onValueChange = { newValue->
                informationScreenViewModel.onWeightChange(newValue,context)
            }
        )
        TextLabel(
            text = stringResource(R.string.age),
            modifier = Modifier.padding(bottom = 10.dp),
            textFont = 18,
            textFontWight = FontWeight.Bold
        )

        NumberEditText(
            number = state.age,
            placeholderID = R.string.enter_your_age,
            isNumberError = state.isErrorAge,
            numberErrorMessage = state.ageErrorMessage,
            onValueChange = {
                newValue-> informationScreenViewModel.onAgeChange(newValue,context)
            }
        )

        TextLabel(
            text = stringResource(R.string.gender),
            modifier = Modifier.padding(bottom = 10.dp),
            textFont = 18,
            textFontWight = FontWeight.Bold
        )

        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            CheckboxWithName(
                checkBoxText = stringResource(R.string.male),
                checkedState = state.male,
                onToggleClick = {
                    informationScreenViewModel.onGenderSelectMale()
                }
            )
            CheckboxWithName(
                checkBoxText = stringResource(R.string.female),
                checkedState = state.female,
                onToggleClick = {
                    informationScreenViewModel.onGenderSelectFemale()
                }
            )

        }


        Row {
            Text(
                state.genderErrorMessage, style = MaterialTheme.typography.bodyMedium, modifier = Modifier
                    .padding(top = 3.dp, start = 25.dp), color = Color.Red
            )
            Spacer(modifier = Modifier.weight(1f))

        }

        Spacer(modifier = Modifier.weight(1f))
        ButtonClickOn(
            buttonText = stringResource(R.string.next),
            paddingValue = 0) {
           informationScreenViewModel.onNextToLastScreen(navController,context)
        }






    }


}
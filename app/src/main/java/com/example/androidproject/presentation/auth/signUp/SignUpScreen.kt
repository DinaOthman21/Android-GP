package com.example.androidproject.presentation.auth.signUp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androidproject.R
import com.example.androidproject.presentation.components.BackIcon
import com.example.androidproject.presentation.components.ButtonClickOn
import com.example.androidproject.presentation.components.EmailEditText
import com.example.androidproject.presentation.components.PasswordEditText
import com.example.androidproject.presentation.components.TextLabel
import com.example.androidproject.presentation.components.UserNameEditText

@Composable
fun SignUpScreen(
    navController: NavController,
    signUpScreenViewModel: SignUpScreenViewModel
)
{
    val state = signUpScreenViewModel.state.value
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(14.dp)
    )
    {

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
            text = stringResource(R.string.full_name),
            modifier = Modifier.padding(top = 30.dp,bottom = 10.dp),
            textFont = 18,
            textFontWight = FontWeight.Bold
        )
        UserNameEditText(
            userName = state.userName,
            isUserNameError = state.isErrorUserName,
            userNameErrorMessage = state.userNameErrorMessage,
            onValueChange = {}
        )
        TextLabel(
            text = stringResource(id = R.string.email),
            modifier = Modifier.padding(bottom = 10.dp),
            textFont = 18,
            textFontWight = FontWeight.Bold
        )
        EmailEditText(
            email = state.email,
            isErrorEmail = state.isErrorEmail,
            emailErrorMessage = state.emailErrorMessage,
            onValueChange = {}
        )

        TextLabel(
            text = stringResource(id = R.string.password),
            modifier = Modifier.padding(bottom = 10.dp),
            textFont = 18,
            textFontWight = FontWeight.Bold
        )

        PasswordEditText(
            password = state.password,
            isErrorPassword = state.isErrorPassword,
            passwordErrorMessage = state.passwordErrorMessage,
            showPassword = state.showPassword,
            onValueChange = {}
        ) {}

        TextLabel(
            text = stringResource(R.string.confirm_password),
            modifier = Modifier.padding(bottom = 10.dp),
            textFont = 18,
            textFontWight = FontWeight.Bold
        )

        PasswordEditText(
            password = state.confirmPassword,
            isErrorPassword = state.isErrorConfirmPassword,
            passwordErrorMessage = state.confirmPasswordErrorMessage,
            showPassword = state.showConfirmPassword,
            onValueChange = {}
        ) {}

        Spacer(modifier = Modifier.weight(1f))

        ButtonClickOn(
            buttonText = stringResource(R.string.next),
            paddingValue = 0) {}


    }
}




@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    val navController = rememberNavController()
    val signUpScreenViewModel = SignUpScreenViewModel()

    SignUpScreen(navController, signUpScreenViewModel)
}
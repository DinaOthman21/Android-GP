package com.example.androidproject.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidproject.R
import com.example.androidproject.presentation.components.AppNameWithHiatusFont
import com.example.androidproject.presentation.components.ButtonClickOn
import com.example.androidproject.presentation.components.CheckboxWithName
import com.example.androidproject.presentation.components.EmailEditText
import com.example.androidproject.presentation.components.PasswordEditText
import com.example.androidproject.presentation.components.TextLabel

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(12.dp)
    ){
        AppNameWithHiatusFont(modifier = Modifier
            .padding(
                start = 15.dp,
                top =35.dp,
                bottom = 20.dp
            ))
        TextLabel(
            text = stringResource(R.string.email),
            modifier = Modifier.padding(bottom = 20.dp),
            textFont = 18,
            textFontWight = FontWeight.Bold
        )
        EmailEditText(
            email = "",
            isErrorEmail = false,
            emailErrorMessage = "",
            onValueChange = {}
        )
        TextLabel(
            text = stringResource(R.string.password),
            modifier = Modifier.padding(top = 15.dp,bottom = 20.dp),
            textFont = 18,
            textFontWight = FontWeight.Bold
        )
        PasswordEditText(
            password = "",
            isErrorPassword = false,
            passwordErrorMessage = "",
            showPassword = false,
            onValueChange = {}
        ) {}

        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            CheckboxWithName(
                checkBoxText = stringResource(R.string.remember_me),
                checkedState = false,
                onToggleClick = {}
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Forgot Password?",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.primary,
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier.clickable {
                    // on forgot password text click
                    // navController.navigate(Screens.ForgotPassword.route)

                }
            )

        }

        ButtonClickOn(
            buttonText = stringResource(R.string.login),
            paddingValue = 30
        ) {
            // on login click
            // loginViewModel.onLoginClick(navController,context)
        }

    }
}
package com.example.androidproject.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.androidproject.R

@Composable
fun AppNameWithHiatusFont(modifier: Modifier = Modifier) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color(0xFF097AC7))) {
                append("MediSim")
            }
            append(" ")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("AI")
            }
        },
        modifier = modifier,
        fontSize = 90.sp,
        fontFamily = FontFamily(Font(R.font.hiatus2)),
    )

}




@Composable
fun TextLabel(
    text: String,
    modifier: Modifier = Modifier,
    textFont: Int = 12,
    textFontWight: FontWeight = FontWeight.Normal,
    textColor: Color = MaterialTheme.colorScheme.primary
) {

    Text(
        text = text,
        modifier = modifier,
        color = textColor,
        fontSize = textFont.sp,
        fontWeight = textFontWight,
    )

}

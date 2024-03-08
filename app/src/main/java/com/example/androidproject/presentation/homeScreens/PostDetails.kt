package com.example.androidproject.presentation.homeScreens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidproject.presentation.components.BackIcon
import com.example.androidproject.presentation.components.Post
import com.example.androidproject.presentation.components.TextLabel
import com.example.androidproject.presentation.components.TextTitle
import com.example.androidproject.presentation.components.ViewImage


@Composable
fun PostDetails(post: Post, navController: NavHostController) {
    Column(
        modifier = Modifier.padding(12.dp),
    ) {
        Row(
            modifier = Modifier.padding(bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BackIcon{ navController.popBackStack()}
        }
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            TextLabel(
                text = "post title",
                textFont = 22,
                textFontWight = FontWeight.Bold
            )
        }
        ViewImage(
            image = post.image,
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .padding(vertical = 15.dp),
        )
        TextTitle(
            text = "Post description here and all content will be here ew kalam keter awy 3shan ana msh fady, Post description here and all content will be here ew kalam keter awy 3shan ana msh fady" +
                    "Post description here and all content will be here ew kalam keter awy 3shan ana msh fady, Post description here and all content will be here ew kalam keter awy 3shan ana msh fady",
            maxLines = 500
        )

    }
}

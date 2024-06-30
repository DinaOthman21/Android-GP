/*
package com.example.androidproject.presentation.homeScreens.bottomNavigation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidproject.R
import com.example.androidproject.presentation.components.HorizontalView
import com.example.androidproject.presentation.components.TextWithBoldUnderLine
import com.example.androidproject.presentation.components.VerticalAvoidCard
import com.example.androidproject.presentation.components.posts
import com.example.androidproject.presentation.navigation.Screens


@Composable
fun HomeScreen(navController:NavHostController) {
    LazyColumn (
        modifier = Modifier.padding(top = 10.dp)
    ){
        item{
            Column {
                // make title for "Advices" with small bold under line
                TextWithBoldUnderLine(
                    text = stringResource(R.string.advices),
                    lineColor  = MaterialTheme.colorScheme.onSecondary
                )

                HorizontalView(){
                    // on post click
                    // on user click on post to show its details
                    navController
                        .currentBackStackEntry
                        ?.savedStateHandle
                        ?.set("post", it) // new
                    navController.navigate(Screens.PostDetails.route)
                }


                // also make title for "Avoid" with small bold under line
                TextWithBoldUnderLine(
                    text = stringResource(R.string.avoid),
                    lineColor  = MaterialTheme.colorScheme.onSecondary
                )
            }
        }

        items(posts){
            VerticalAvoidCard(post = it) {
                // on post click
                // on user click on post to show its details
                navController
                    .currentBackStackEntry
                    ?.savedStateHandle
                    ?.set("post", it) // new
                navController.navigate(Screens.PostDetails.route)

            }
        }

    }

}
*/

package com.example.androidproject.presentation.homeScreens.bottomNavigation.home

/*
package com.example.androidproject.presentation.homeScreens.bottomNavigation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidproject.R
import com.example.androidproject.presentation.components.HorizontalView
import com.example.androidproject.presentation.components.TextWithBoldUnderLine
import com.example.androidproject.presentation.components.VerticalAvoidCard
import com.example.androidproject.presentation.components.posts
import com.example.androidproject.presentation.navigation.Screens


@Composable
fun HomeScreen(navController:NavHostController) {
    LazyColumn (
        modifier = Modifier.padding(top = 10.dp)
    ){
        item{
            Column {
                // make title for "Advices" with small bold under line
                TextWithBoldUnderLine(
                    text = stringResource(R.string.advices),
                    lineColor  = MaterialTheme.colorScheme.onSecondary
                )

                HorizontalView(){
                    // on post click
                    // on user click on post to show its details
                    navController
                        .currentBackStackEntry
                        ?.savedStateHandle
                        ?.set("post", it) // new
                    navController.navigate(Screens.PostDetails.route)
                }


                // also make title for "Avoid" with small bold under line
                TextWithBoldUnderLine(
                    text = stringResource(R.string.avoid),
                    lineColor  = MaterialTheme.colorScheme.onSecondary
                )
            }
        }

        items(posts){
            VerticalAvoidCard(post = it) {
                // on post click
                // on user click on post to show its details
                navController
                    .currentBackStackEntry
                    ?.savedStateHandle
                    ?.set("post", it) // new
                navController.navigate(Screens.PostDetails.route)

            }
        }

    }

}*/


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidproject.R
import com.example.androidproject.presentation.components.HorizontalView
import com.example.androidproject.presentation.components.TextWithBoldUnderLine
import com.example.androidproject.presentation.components.VerticalAvoidCard
import com.example.androidproject.presentation.components.posts
import com.example.androidproject.presentation.homeScreens.BottomAppBar.BottomAppBar
import com.example.androidproject.presentation.homeScreens.BottomAppBar.BottomBarItem
import com.example.androidproject.presentation.navigation.Screens
import com.example.androidproject.presentation.homeScreens.TopAppBar


@Composable
fun HomeScreen(navController: NavHostController) {
    var selectedItem by remember { mutableStateOf(0) }

    val items = listOf(
        BottomBarItem.Home,
        BottomBarItem.Prediction,
        BottomBarItem.Medicine,
        BottomBarItem.Calculator
    )



    Column {

        TopAppBar(
            onProfileClick = {
                // Navigate to profile screen or perform profile action
                //navController.navigate(Screens.Profile.route)
            },
            onChatClick = {
                // Navigate to chat screen or perform chat action
                // navController.navigate(Screens.Chat.route)
            }
        )

        LazyColumn(
            modifier = Modifier.padding(top = 10.dp,bottom = 67.dp)
        ) {
            item {
                Column {
                    // make title for "Advices" with small bold underline
                    TextWithBoldUnderLine(
                        text = stringResource(R.string.advices),
                        lineColor = MaterialTheme.colorScheme.onSecondary
                    )

                    HorizontalView {
                        // on post click
                        // on user click on post to show its details
                        navController.currentBackStackEntry?.savedStateHandle?.set("post", it)
                        navController.navigate(Screens.PostDetails.route)
                    }

                    // also make title for "Avoid" with small bold underline
                    TextWithBoldUnderLine(
                        text = stringResource(R.string.avoid),
                        lineColor = MaterialTheme.colorScheme.onSecondary
                    )
                }
            }

            items(posts) { post ->
                VerticalAvoidCard(post = post) {
                    // on post click
                    // on user click on post to show its details
                    navController.currentBackStackEntry?.savedStateHandle?.set("post", post)
                    navController.navigate(Screens.PostDetails.route)
                }
            }
        }


    }

    BottomAppBar(
        items = items,
        selectedItem = selectedItem,
        onItemClick = { index ->
            selectedItem = index
            when (index) {
                1 -> navController.navigate(Screens.Prediction.route)
                2 -> navController.navigate(Screens.Medicine.route)
                3 -> navController.navigate(Screens.Calculator.route)
            }
        }
    )


}

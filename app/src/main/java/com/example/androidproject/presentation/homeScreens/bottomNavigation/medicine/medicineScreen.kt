package com.example.androidproject.presentation.homeScreens.bottomNavigation.medicine



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androidproject.presentation.homeScreens.BottomAppBar.BottomAppBar
import com.example.androidproject.presentation.homeScreens.BottomAppBar.BottomBarItem
import com.example.androidproject.presentation.navigation.Screens

@Composable
fun MedicineScreen(navController: NavHostController){

    var selectedItem by remember { mutableStateOf(2) }

    val items = listOf(
        BottomBarItem.Home,
        BottomBarItem.Prediction,
        BottomBarItem.Medicine,
        BottomBarItem.Calculator
    )

    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier=Modifier.fillMaxSize().align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text="Medicine", fontSize = 18.sp, style = TextStyle(color = Color.Blue))

        }
    }

    BottomAppBar(
        items = items,
        selectedItem = selectedItem,
        onItemClick = { index ->
            selectedItem = index
            when (index) {
                0 ->navController.navigate(Screens.Home.route)
                1 -> navController.navigate(Screens.Prediction.route)
                3 -> navController.navigate(Screens.Calculator.route)
            }
        }
    )


}


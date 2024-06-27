package com.example.androidproject.presentation.homeScreens


import com.example.androidproject.R
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size


import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidproject.ui.theme.AndroidProjectTheme

@Composable
fun BottomAppBar(
    items: List<BottomNavigationItem>,
    selectedItem: Int,
    onItemClick: (Int) -> Unit,
    onFabClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        NavigationBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(67.dp),
            containerColor = Color(0xFF97CADB),
            tonalElevation = 10.dp
        ) {
            items.forEachIndexed { index, item ->
                if (index == 2) {
                    Spacer(Modifier.weight(1f, true))
                } else {
                    NavigationBarItem(
                        selected = index == selectedItem,
                        onClick = { onItemClick(index) },
                        icon = {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(25.dp),
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = item.text,
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                            selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                            unselectedIconColor = colorResource(id = R.color.white),
                            unselectedTextColor = colorResource(id = R.color.white),
                            indicatorColor = MaterialTheme.colorScheme.background
                        ),
                    )
                }
            }
        }

        FloatingActionButton(
            onClick = onFabClick,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-30).dp),
            shape = CircleShape,
            containerColor = MaterialTheme.colorScheme.onPrimary,
            contentColor =  colorResource(id = R.color.white),
            elevation = FloatingActionButtonDefaults.elevation(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.medicaltest),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}

data class BottomNavigationItem(
    @DrawableRes val icon: Int,
    val text: String
)


@Preview
@Composable
fun BottomAppBarPreview() {
    val items = listOf(
        BottomNavigationItem(icon = R.drawable.home, text = "Home"),
        BottomNavigationItem(icon = R.drawable.prediction, text = "Prediction"),
        BottomNavigationItem(icon = R.drawable.medicaltest, text = ""),
        BottomNavigationItem(icon = R.drawable.medicine, text = "Drug"),
        BottomNavigationItem(icon = R.drawable.calculator, text = "Calculator")
    )

    AndroidProjectTheme(dynamicColor = false) {
        BottomAppBar(
            items = items,
            selectedItem = 0,
            onItemClick = {},
            onFabClick = {}
        )
    }

}





package com.example.androidproject.presentation.homeScreens.BottomAppBar




import com.example.androidproject.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
    items: List<BottomBarItem>,
    selectedItem: Int,
    onItemClick: (Int) -> Unit,
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
}



@Preview
@Composable
fun BottomAppBarPreview() {
    val items = listOf(
        BottomBarItem.Home,
        BottomBarItem.Prediction,
        BottomBarItem.Medicine,
        BottomBarItem.Calculator
    )

    AndroidProjectTheme(dynamicColor = false) {
        BottomAppBar(
            items = items,
            selectedItem = 0,
            onItemClick = {},
        )
    }

}





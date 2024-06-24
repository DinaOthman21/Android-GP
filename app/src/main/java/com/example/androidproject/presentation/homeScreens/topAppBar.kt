/*
package com.example.androidproject.presentation.homeScreens

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    onProfileClick: () -> Unit,
    onChatClick: () -> Unit,
) {
    val iconSize = 24.dp
    val iconColor = Color(0xFF001B48)

    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(0xFF97CADB),
            actionIconContentColor =  MaterialTheme.colorScheme.onSecondary,
            navigationIconContentColor = MaterialTheme.colorScheme.onSecondary,
        ),
        title = {},
        navigationIcon = {
            IconButton(onClick = onProfileClick) {
                Icon(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier.size(iconSize)
                )
            }
        },
        actions = {
            IconButton(onClick = onChatClick) {
                Icon(
                    painter = painterResource(id = R.drawable.chat),
                    contentDescription = null,
                    modifier = Modifier.size(iconSize)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailsTopBar() {
    AppTopBar(
        onProfileClick = {},
        onChatClick = {}
    )
}
*/

package com.example.androidproject.presentation.homeScreens

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidproject.R
import com.example.androidproject.ui.theme.TextLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    onProfileClick: () -> Unit,
    onChatClick: () -> Unit,
    showTopAppBar: Boolean = true // Add a parameter to control visibility
) {
    if (showTopAppBar) {
        val iconSize = 24.dp

        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color(0xFF97CADB),
                actionIconContentColor = TextLight,
                navigationIconContentColor = TextLight,
            ),
            title = {},
            navigationIcon = {
                IconButton(onClick = onProfileClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        modifier = Modifier.size(iconSize)
                    )
                }
            },
            actions = {
                IconButton(onClick = onChatClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.chat),
                        contentDescription = null,
                        modifier = Modifier.size(iconSize)
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailsTopBar() {
    AppTopBar(
        onProfileClick = {},
        onChatClick = {},
        showTopAppBar = true // Ensure it's shown in preview
    )
}

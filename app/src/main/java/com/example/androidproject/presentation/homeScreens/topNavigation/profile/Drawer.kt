package com.example.androidproject.presentation.homeScreens.topNavigation.profile


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidproject.R
import com.example.androidproject.presentation.components.CircleInitials
import com.example.androidproject.presentation.components.TextLabel
import com.example.androidproject.ui.theme.AndroidProjectTheme


@Composable
fun NavigationDrawerHeader(profileViewModel: ProfileViewModel) {
    profileViewModel.getUserInfo()
    val state = profileViewModel.state.value
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .clip(
                    shape = RoundedCornerShape(
                        bottomStart = 150.dp,
                    )
                )
                .background(MaterialTheme.colorScheme.tertiary),
        ) {
            Row(
                modifier = Modifier.padding(20.dp, top = 50.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                 CircleInitials(name = state.userName)
                Column(
                    modifier = Modifier.padding(start = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextLabel(
                        text = state.userName,
                        textFont = 18
                    )
                    TextLabel(
                        text = state.email,
                        modifier = Modifier.padding(top = 10.dp),
                        textFont = 13
                    )
                }
            }
        }
    }
}




@Composable
fun NavigationDrawerBody(navController: NavHostController, profileViewModel: ProfileViewModel) {
    val state = profileViewModel.state.value
    val context = LocalContext.current
    val resources = context.resources

    val localeOptions = mapOf(
        R.string.en to "en",
        R.string.ar to "ar",
    ).mapKeys { stringResource(it.key) }

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(start = 12.dp)
    ) {
        item {
            TextLabel(
                text = stringResource(R.string.general_settings),
                modifier = Modifier.padding(start = 3.dp, bottom = 10.dp),
                textFont = 18,
                textColor = MaterialTheme.colorScheme.secondary
            )
            BodyItem(
                item = DrawerItem.Language,
                title = stringResource(R.string.language),
                iconColor = DrawerItem.Language.color,
                onRowClick = { profileViewModel.onShowBottomSheet() }
            )
            BodyItem(
                item = DrawerItem.Mode,
                title = stringResource(R.string.dark_mode),
                iconColor = DrawerItem.Mode.color,
                isDark = state.isDark,
                onRowClick = {}
            ) { profileViewModel.onChangeMode() }
            LineWithText(stringId = R.string.about)
            BodyItem(
                item = DrawerItem.TermsAndConditions,
                title = stringResource(R.string.terms_conditions),
                iconColor = DrawerItem.TermsAndConditions.color,
                onRowClick = {}
            )
            BodyItem(
                item = DrawerItem.License,
                title = stringResource(R.string.license),
                iconColor = DrawerItem.License.color,
                onRowClick = {}
            )
            BodyItem(
                item = DrawerItem.Rate,
                title = stringResource(R.string.rate_this_app),
                iconColor = DrawerItem.Rate.color,
                onRowClick = {}
            )
            BodyItem(
                item = DrawerItem.Share,
                title = stringResource(R.string.share_this_app),
                iconColor = DrawerItem.Share.color,
                onRowClick = {
                    shareText(context, "Check out this app!", "https://play.google.com/store/search?q=medithen+ai&c=apps")
                }
            )
            LineWithText(stringId = R.string.account_settings)
            BodyItem(
                item = DrawerItem.Logout,
                title = stringResource(R.string.log_out),
                iconColor = DrawerItem.Logout.color,
                onRowClick = {
                    profileViewModel.onLogoutClick(navController)
                }
            )
        }
        item {
            AnimatedVisibility(
                visible = state.isBottomSheetShow,
            ) {
                LanguageBottomSheet(
                    isArabic = state.isArabic,
                    onDismissRequest = { profileViewModel.onDismissRequest() },
                    onSelectLanguage = { selectionLocale -> profileViewModel.onSelectLanguage(localeOptions[selectionLocale]!!, resources) }
                )
            }
        }
    }
}


@Composable
fun NavigationDrawerUI(navController: NavHostController, profileViewModel: ProfileViewModel) {
    Column {
        NavigationDrawerHeader(profileViewModel = profileViewModel)
        NavigationDrawerBody(navController = navController, profileViewModel = profileViewModel)
    }
}





@Preview(showBackground = true)
@Composable
fun PreviewNavigationDrawer() {
    AndroidProjectTheme {
        val navController = rememberNavController()
        val profileViewModel: ProfileViewModel = viewModel()
        NavigationDrawerUI(navController = navController, profileViewModel = profileViewModel)
    }
}
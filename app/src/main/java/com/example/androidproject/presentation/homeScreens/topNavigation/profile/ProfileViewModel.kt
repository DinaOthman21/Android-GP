package com.example.androidproject.presentation.homeScreens.topNavigation.profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController


class ProfileViewModel : ViewModel() {
    val state = mutableStateOf(ProfileState())

    fun getUserInfo() {

    }

    fun onShowBottomSheet() {
        state.value = state.value.copy(isBottomSheetShow = true)
    }

    fun onDismissRequest() {
        state.value = state.value.copy(isBottomSheetShow = false)
    }

    fun onChangeMode() {
        state.value = state.value.copy(isDark = !state.value.isDark)
    }

    fun onSelectLanguage(language: String, resources: android.content.res.Resources) {

    }

    fun onLogoutClick(navController: NavController) {

    }
}
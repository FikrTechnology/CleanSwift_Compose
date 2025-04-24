package com.example.cleanswift.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
}
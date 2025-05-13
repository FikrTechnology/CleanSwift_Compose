package com.example.cleanswift.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object NavHome : Screen("nav_home")
    object Home : Screen("home")
    object Progress : Screen("progress")
    object Done : Screen("done")
    object DetailCustomer : Screen("detail_customer")
    object UpdateCustomer : Screen("update_customer")
}
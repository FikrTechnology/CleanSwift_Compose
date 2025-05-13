package com.example.cleanswift.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.cleanswift.R
import com.example.cleanswift.data.model.NavigationItem
import com.example.cleanswift.presentation.doneprogress.DoneProgressScreen
import com.example.cleanswift.presentation.home.HomeScreen
import com.example.cleanswift.presentation.onprogress.OnProgressScreen
import com.example.cleanswift.ui.theme.CleanSwiftColor

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NavigationHome() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navigationItems = listOf(
        NavigationItem(
            title = "Home",
            icon = painterResource(id = R.drawable.home_2),
            route = Screen.Home.route
        ),
        NavigationItem(
            title = "Progress",
            icon = painterResource(id = R.drawable.archive),
            route = Screen.Progress.route
        ),
        NavigationItem(
            title = "Done",
            icon = painterResource(id = R.drawable.copy_success),
            route = Screen.Done.route
        ),
    )

    BackHandler(enabled = currentRoute != Screen.Home.route) {
        navController.navigate(Screen.Home.route) {
            launchSingleTop = true
            popUpTo(navController.graph.startDestinationId) {
                inclusive = false
            }
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .wrapContentHeight(),
                containerColor = CleanSwiftColor.Primary
            ) {
                navigationItems.forEachIndexed { index, item ->
                    val isSelected = currentRoute == item.route
                    NavigationBarItem(
                        icon = {
                            Icon(
                                painter = item.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = item.title)
                        },
                        selected = isSelected,
                        onClick = {
                            if (currentRoute != item.route) {
                                navController.navigate(item.route) {
                                    launchSingleTop = true
                                    restoreState = true
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                }
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = CleanSwiftColor.SecondaryVariant,
                        )
                    )
                }
            }
        }
    ) { innerPadding ->

        val graph = navController.createGraph(
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Progress.route) {
                OnProgressScreen()
            }
            composable(Screen.Done.route) {
                DoneProgressScreen()
            }
        }

        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            graph = graph
        )
    }
}
package com.example.foodly.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodly.Customers.Splash.navigation.Screen
import com.example.foodly.model.BottomNavItem
import com.example.foodly.ui.theme.colorWhite
import com.example.foodly.ui.theme.orange2

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem(
            route = Screen.HomeScreen.route,
            icon = Icons.Outlined.Home,
            contentDescription = "Home"
        ),
        BottomNavItem(
            route = Screen.FavoriteScreen.route,
            icon = Icons.Outlined.Favorite,
            contentDescription = "Favorite"
        ),
        BottomNavItem(
            route = Screen.HomeScreenRestaurant.route,
            icon = Icons.Outlined.RestaurantMenu,
            contentDescription = "Restaurant Menu",
        ),
        BottomNavItem(
            route = Screen.OrderScreen.route,
            icon = Icons.Outlined.Lock,
            contentDescription = "Order",
            alertCount = 4
        ),
        BottomNavItem(
            route = Screen.ProfileScreen.route,
            icon = Icons.Outlined.Person,
            contentDescription = "Profile"
        ),
    ),
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = MaterialTheme.colors.surface,
                    cutoutShape = CircleShape,
                    elevation = 0.dp
                ) {
                    BottomNavigation(backgroundColor = colorWhite) {

                        bottomNavItems.forEachIndexed { i, bottomNavItem ->
                            StandardBottomNavItem(
                                icon = bottomNavItem.icon,
                                contentDescription = bottomNavItem.contentDescription,
                                selected = bottomNavItem.route == navController.currentDestination?.route,
                                alertCount = bottomNavItem.alertCount,
                                enabled = bottomNavItem.icon != null
                            ) {
                                if (navController.currentDestination?.route != bottomNavItem.route) {
                                    navController.navigate(bottomNavItem.route)
                                }
                            }
                        }
                    }
                }
            }
        }/*
        floatingActionButton = {
            if (showBottomBar) {
                FloatingActionButton(
                    backgroundColor = orange2,
                    onClick = onFabClick
                ) {
                    Icon(
                        imageVector = Icons.Outlined.RestaurantMenu,
                        contentDescription = "Restaurant Menu",
                        tint = colorWhite
                    )
                }
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        modifier = modifier*/
    ) {
        content()
    }
}
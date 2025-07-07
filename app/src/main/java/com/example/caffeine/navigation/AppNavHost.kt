package com.example.caffeine.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.caffeine.screen.coffeeType.CoffeeTypeScreen
import com.example.caffeine.screen.home.HomeScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: Destination = Destination.START
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(Destination.START.route) {
            HomeScreen {
                navController.navigateToCoffeeTypeScreen()
            }
        }
        composable(Destination.COFFEE_TYPE.route) {
            CoffeeTypeScreen {
                navController.navigateToCupSizeScreen()
            }
        }
        composable(Destination.CUP_SIZE.route) {

        }
        composable(Destination.ORDER.route) {

        }
        composable(Destination.SNACK_TYPE.route) {
        }
    }
}

fun NavHostController.navigateToCoffeeTypeScreen() = navigate(Destination.COFFEE_TYPE.route)
fun NavHostController.navigateToCupSizeScreen() = navigate(Destination.CUP_SIZE.route)

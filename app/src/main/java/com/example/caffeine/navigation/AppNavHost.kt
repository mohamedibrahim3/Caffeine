package com.example.caffeine.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.caffeine.screen.coffeeSize.CoffeeSizeScreen
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
            CoffeeTypeScreen { coffeeType ->
                navController.navigateToCoffeeSizeScreen(coffeeType)
            }
        }
        composable(
            route = "${Destination.COFFEE_SIZE.route}/{coffeeType}",
            arguments = listOf(navArgument("coffeeType") { type = NavType.StringType })
        ) { backStackEntry ->
            val coffeeType = backStackEntry.arguments?.getString("coffeeType") ?: ""
            CoffeeSizeScreen(coffeeType = coffeeType) {
                navController.popBackStack()
            }
        }
        composable(Destination.ORDER.route) {
            // Order screen implementation
        }
        composable(Destination.SNACK_TYPE.route) {
            // Snack type screen implementation
        }
    }
}

fun NavHostController.navigateToCoffeeTypeScreen() = navigate(Destination.COFFEE_TYPE.route)
fun NavHostController.navigateToCoffeeSizeScreen(coffeeType: String) =
    navigate("${Destination.COFFEE_SIZE.route}/$coffeeType")
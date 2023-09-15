package com.example.stage_two

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navHostController: NavHostController) {
    val vm : HomeViewModel = viewModel()
    NavHost(navController = navHostController, startDestination = Screens.HOME ){

        composable(route = Screens.HOME){
            HomeScreen(homeViewModel = vm){
                navHostController.navigate(Screens.EDIT)
            }
        }
        composable(route = Screens.EDIT){
            EditScreen(homeViewModel = vm) {
                navHostController.navigate(Screens.HOME)
            }
        }
    }
}
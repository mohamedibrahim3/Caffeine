package com.example.caffeine.screen.coffeeSize

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.caffeine.screen.coffeeSize.viewmodel.CoffeeSizeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CoffeeSizeScreen(
    viewModel: CoffeeSizeViewModel = koinViewModel(),
    coffeeType: String,
    onBackClick: () -> Unit
) {
    val state by viewModel.state.collectAsState()
    CoffeeSizeContent(state, viewModel, coffeeType, onBackClick)
}
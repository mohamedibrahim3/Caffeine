package com.example.caffeine.screen.coffeeSize.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.caffeine.screen.coffeeSize.state.CoffeeSizeInteraction
import com.example.caffeine.screen.coffeeSize.model.CoffeeAmount
import com.example.caffeine.screen.coffeeSize.model.CoffeeSize
import com.example.caffeine.screen.coffeeSize.state.CoffeeSizeState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoffeeSizeViewModel : ViewModel(), CoffeeSizeInteraction {

    private val _state = MutableStateFlow(CoffeeSizeState())
    val state = _state.asStateFlow()

    override fun onCoffeeSizeSelected(size: CoffeeSize) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(selectedSize = size) }
        }
    }

    override fun onCoffeeAmountSelected(amount: CoffeeAmount) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(amountCoffee = amount) }
        }
    }

    override fun onPrepareCoffee() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isCoffeePrepared = true) }
            delay(5000)
            _state.update { it.copy(isCoffeeReady = true) }
        }
    }
}
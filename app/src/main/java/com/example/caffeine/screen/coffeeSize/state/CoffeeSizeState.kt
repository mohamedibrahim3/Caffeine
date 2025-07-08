package com.example.caffeine.screen.coffeeSize.state

import com.example.caffeine.screen.coffeeSize.model.CoffeeAmount
import com.example.caffeine.screen.coffeeSize.model.CoffeeSize

data class CoffeeSizeState(
    val selectedSize: CoffeeSize = CoffeeSize.SMALL,
    val amountCoffee: CoffeeAmount = CoffeeAmount.LOW,
    val isCoffeePrepared: Boolean = false
)
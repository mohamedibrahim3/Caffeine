package com.example.caffeine.screen.coffeeSize.state

import com.example.caffeine.screen.coffeeSize.model.CoffeeAmount
import com.example.caffeine.screen.coffeeSize.model.CoffeeSize

interface CoffeeSizeInteraction {
    fun onCoffeeSizeSelected(size: CoffeeSize)
    fun onCoffeeAmountSelected(amount: CoffeeAmount)
    fun onPrepareCoffee()
}
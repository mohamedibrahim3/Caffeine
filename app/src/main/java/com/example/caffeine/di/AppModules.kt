package com.example.caffeine.di

import com.example.caffeine.screen.coffeeSize.viewmodel.CoffeeSizeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::CoffeeSizeViewModel)
}
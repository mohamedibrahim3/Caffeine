package com.example.caffeine.navigation

enum class Destination(
    val route: String,
) {
    START("start"),
    COFFEE_TYPE("coffee type"),
    CUP_SIZE("cup size"),
    ORDER("order"),
    SNACK_TYPE("snack type"),
}
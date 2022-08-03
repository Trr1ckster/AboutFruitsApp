package com.example.aboutfruits

data class Fruits(
    val name: String,
    val id: Int,
    val family: String,
    val genus: String,
    val order: String,
    val nutritions: Nutritions)

data class Nutritions(
    val carbohydrates: Double,
    val protein: Double,
    val fat: Double,
    val calories: Int,
    val sugar: Double
)
package com.ahuaman.domain

data class RecipeDomain(
    val id: String,
    val title: String,
    val image: String,
    val extendedIngredients: List<IngredientDomain>,
    val summary: String,
    val type: String?= null,
    val instructions: String,
    val healthScore: Float,
    val author: String?= null,
    val address: String?= null,
    val authorImage: String?= null,
    val lat: Double?= null,
    val lon: Double?= null,
)

data class IngredientDomain(
    val id: String,
    val name: String,
    val image: String,
)

data class RecipeResponse(
    val recipes: List<RecipeDomain>
)
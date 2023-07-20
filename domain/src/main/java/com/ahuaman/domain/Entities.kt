package com.ahuaman.domain

data class RecipeDomain(
    val id: String,
    val title: String,
    val image: String,
    val ingredients: List<String>,
    val description: String,
    val instructions: String,
    val tags: List<String>,
    val score: Float,
    val author: String?= null,
    val address: String?= null,
    val authorImage: String?= null,
)

data class RecipeResponse(
    val recipes: List<RecipeDomain>
)
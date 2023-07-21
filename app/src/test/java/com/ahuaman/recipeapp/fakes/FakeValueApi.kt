package com.example.usecases.fakes

import com.ahuaman.domain.IngredientDomain
import com.ahuaman.domain.RecipeDomain
import com.ahuaman.domain.RecipeResponse

object FakeValueApi {

    fun getRecipesResponseFake() = RecipeResponse(
       listOf(
           RecipeDomain(
               id = "1",
               title = "Recipe 1",
               image = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
               summary = "Description 1",
               extendedIngredients = listOf(
                   IngredientDomain(
                       id = "1",
                       name = "Ingredient 1",
                       image = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
                   )
               ),
               instructions = "Instructions 1",
               healthScore = 4.5f,
           ),
           RecipeDomain(
               id = "2",
               title = "Recipe 2",
               image = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
               summary = "Description 2",
               extendedIngredients = listOf(
                   IngredientDomain(
                       id = "1",
                       name = "Ingredient 1",
                       image = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
                   )
               ),
               instructions = "Instructions 2",
               healthScore = 4.5f
           ),

           RecipeDomain(
               id = "3",
               title = "Recipe 3",
               image = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
               summary = "Description 3",
               extendedIngredients = listOf(
                   IngredientDomain(
                       id = "1",
                       name = "Ingredient 1",
                       image = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
                   )
               ),
               instructions = "Instructions 3",
               healthScore = 3.5f
           ),

           RecipeDomain(
               id = "4",
               title = "Recipe 4",
               image = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
               summary = "Description 4",
               extendedIngredients = listOf(
                   IngredientDomain(
                       id = "1",
                       name = "Ingredient 1",
                       image = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
                   )
               ),
               instructions = "Instructions 4",
               healthScore = 7f
           ),
       )
    )
}
package com.example.usecases

import com.ahuaman.recipeapp.data.repository.Repository
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke() = repository.getRecipes()
}
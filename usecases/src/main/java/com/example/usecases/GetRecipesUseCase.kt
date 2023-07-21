package com.example.usecases

import com.ahuaman.recipeapp.data.repository.Repository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke() = repository.getRecipes().map {
        it.recipes
    }
}
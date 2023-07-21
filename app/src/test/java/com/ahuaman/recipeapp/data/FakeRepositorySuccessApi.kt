package com.example.usecases.data


import com.ahuaman.domain.RecipeResponse
import com.ahuaman.recipeapp.data.repository.Repository
import com.example.usecases.fakes.FakeValueApi.getRecipesResponseFake
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.seconds

class FakeRepositorySuccessApi : Repository {

    override fun getRecipes(): Flow<RecipeResponse> {
        return flow {
            delay(2.seconds) // Simulate network delay
            emit(getRecipesResponseFake())
        }
    }
}
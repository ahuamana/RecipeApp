package com.ahuaman.recipeapp.data.repository

import com.ahuaman.domain.RecipeResponse
import com.ahuaman.network.performNetworkFlow
import com.ahuaman.recipeapp.data.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface Repository {
    fun getRecipes(): Flow<RecipeResponse>
}

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : Repository {
    override fun getRecipes(): Flow<RecipeResponse> = performNetworkFlow {
        remoteDataSource.getRecipes()
    }
}
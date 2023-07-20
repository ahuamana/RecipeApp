package com.ahuaman.recipeapp.data.remote

import com.ahuaman.domain.RecipeResponse
import com.ahuaman.network.BaseDataSource
import com.ahuaman.recipeapp.data.service.ReqresService

import javax.inject.Inject

interface RemoteDataSource {
    suspend fun getRecipes() : RecipeResponse
}

class RemoteDataSourceImpl @Inject constructor(
    private val requestService: ReqresService
) : BaseDataSource(), RemoteDataSource {
    override suspend fun getRecipes(): RecipeResponse  = getResult(
        call = { requestService.getRecipes() },
        forceError = false
    )

}
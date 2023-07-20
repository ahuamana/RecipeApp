package com.ahuaman.recipeapp.data.service


import com.ahuaman.domain.RecipeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ReqresService {

    @GET("recipes")
    suspend fun getRecipes(): Response<RecipeResponse>


}
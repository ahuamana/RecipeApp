package com.example.usecases.data


import com.ahuaman.domain.RecipeResponse
import com.ahuaman.recipeapp.data.repository.Repository
import com.ahuaman.recipeapp.data.repository.RepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException

class FakeRepositoryErrorApi : Repository {
    override fun getRecipes(): Flow<RecipeResponse> {
        return flow {
            throw HttpException(
                retrofit2.Response.error<String>(
                    500,
                    "Error".toResponseBody("application/json".toMediaTypeOrNull())
                )
            )
        }
    }
}
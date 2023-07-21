package com.example.usecases

import com.ahuaman.domain.RecipeDomain
import com.example.usecases.data.FakeRepositoryErrorApi
import com.example.usecases.data.FakeRepositorySuccessApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException

class GetRecipesUseCaseTest {

    //SUT -> System Under Test
    private lateinit var sut: GetRecipesUseCase
    private lateinit var sutSuccess: GetRecipesUseCase

    //DOC -> Dependency of Component
    private lateinit var fakeRepositoryFailureApi: FakeRepositoryErrorApi
    private lateinit var fakeRepositorySuccessApi: FakeRepositorySuccessApi

    //Save collect result
    private val listRecipes = mutableListOf<RecipeDomain>()

    @Before
    fun setUp() {
        fakeRepositoryFailureApi = FakeRepositoryErrorApi()
        sut = GetRecipesUseCase(fakeRepositoryFailureApi)

        fakeRepositorySuccessApi = FakeRepositorySuccessApi()
        sutSuccess = GetRecipesUseCase(fakeRepositorySuccessApi)
    }


    @Test
    fun `should return success with list converted to domain when network request is success`() = runBlocking {

        val result = sutSuccess.invoke()

        result.collect{
            listRecipes += it
        }

        //Assert
        assert(listRecipes.isNotEmpty())
    }

    @Test(expected = HttpException::class)
    fun `should return exception when network request is failed`() = runBlocking {
        //Arrange

        //Act
        val result = sut.invoke()

        result.collect {
            //Assert
            listRecipes += it
        }
    }



    @After
    fun tearDown() {
        listRecipes.clear()
    }
}
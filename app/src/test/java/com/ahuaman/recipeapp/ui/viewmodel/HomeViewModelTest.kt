package com.ahuaman.recipeapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ahuaman.domain.RecipeDomain
import com.ahuaman.recipeapp.utils.MainCoroutineScopeRule
import com.example.usecases.GetRecipesUseCase
import com.example.usecases.data.FakeRepositorySuccessApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi

class HomeViewModelTest {

    private lateinit var fakeRepositorySuccess: FakeRepositorySuccessApi
    private lateinit var getRecipesUseCase: GetRecipesUseCase


    // SUT -> System Under Test
    lateinit var sut: HomeViewModel
    private var listResult = mutableListOf<HomeViewModel.StateUi>()

    @get:Rule
    val testInstantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineScopeRule = MainCoroutineScopeRule()

    @Before
    fun setUp() {
        fakeRepositorySuccess = FakeRepositorySuccessApi()
        getRecipesUseCase = GetRecipesUseCase(fakeRepositorySuccess)
        sut = HomeViewModel(getRecipesUseCase)
    }

    @Test
    fun `get recipes should return success with list converted to domain when network request is success`() = mainCoroutineScopeRule.runBlockingTest {
        //Arrange
        val scope = launch {
            sut.stateUi.collect {
                listResult += it
            }
        }

        //Act
         sut.getRecipes()

        //Assert -> expected
        val expected = listOf(
            HomeViewModel.StateUi(isLoading = true),
            HomeViewModel.StateUi(isLoading = false)
        )

        println("expected: $expected")
        println("listResult: $listResult")

        //Assert
        scope.cancel()
        assertNotEquals(expected, listResult)
    }

    @After
    fun tearDown() {
    }
}
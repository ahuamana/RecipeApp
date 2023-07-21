package com.ahuaman.recipeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahuaman.domain.RecipeDomain
import com.example.usecases.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRecipesUseCase: GetRecipesUseCase
):ViewModel() {

    private val _listRecipes = MutableStateFlow<List<RecipeDomain>>(emptyList())
    val listRecipes get() = _listRecipes.asStateFlow()

    private val savedRecipes = mutableListOf<RecipeDomain>()

    init {
        getRecipes()
    }

    private fun getRecipes() = viewModelScope.launch(Dispatchers.IO){
        getRecipesUseCase.invoke()
            .onStart {
                //show loading
            }.onEach {
                //update ui
                savedRecipes.addAll(it)
                _listRecipes.value = it
            }.onCompletion {
                //hide loading
            }.launchIn(viewModelScope)
    }

    //search recipe by extendedIngredients
    fun searchRecipeByIngredients(ingredients:String) = viewModelScope.launch(Dispatchers.IO){
        if(ingredients.isEmpty()){
            _listRecipes.value = savedRecipes
            return@launch
        }
        val listRecipes = savedRecipes.filter { recipe ->
            recipe.extendedIngredients.any { ingredient ->
                ingredient.name.contains(ingredients, ignoreCase = true)
            }
        }
        _listRecipes.value = listRecipes
    }


}
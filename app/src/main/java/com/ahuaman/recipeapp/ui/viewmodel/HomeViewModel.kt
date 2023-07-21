package com.ahuaman.recipeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahuaman.domain.RecipeDomain
import com.example.usecases.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
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

    private val _stateUi = MutableStateFlow<StateUi>(StateUi())
    val stateUi get() = _stateUi.asStateFlow()

    private val savedRecipes = mutableListOf<RecipeDomain>()

    init {
        getRecipes()
    }

    fun getRecipes() = viewModelScope.launch(Dispatchers.IO){
        getRecipesUseCase.invoke()
            .onStart {
                _stateUi.value = StateUi(isLoading = true)
            }.onEach {
                //update ui
                savedRecipes.addAll(it)
                _stateUi.value = StateUi(listRecipes = it)
            }.onCompletion {
                //hide loading
            }.catch {
                //show error
                _stateUi.value = StateUi(error = it.message ?: "Error")
            }.launchIn(viewModelScope)
    }


    //search recipe by extendedIngredients
    fun searchRecipeByIngredients(ingredients:String) = viewModelScope.launch(Dispatchers.Default){
        if(ingredients.isEmpty()){
            _stateUi.value = StateUi(listRecipes = savedRecipes)
            return@launch
        }
        val listRecipes = savedRecipes.filter { recipe ->
            recipe.extendedIngredients.any { ingredient ->
                ingredient.name.contains(ingredients, ignoreCase = true)
            }
        }
        _stateUi.value = StateUi(listRecipes = listRecipes)
    }

    data class StateUi(
        val listRecipes:List<RecipeDomain> = emptyList(),
        val isLoading:Boolean = false,
        val error:String = ""
    )
}


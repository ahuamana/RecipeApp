package com.ahuaman.recipeapp.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ahuaman.domain.RecipeDomain
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
):ViewModel() {

    private val _recipe = MutableStateFlow<RecipeDomain?>(null)
    val recipe = _recipe.asStateFlow()

    init {
        //recipe get
        savedStateHandle.get<String>("recipe")?.let { recipe ->
            val recipeDomain = Gson().fromJson(recipe, RecipeDomain::class.java)
            _recipe.value = recipeDomain
        }
    }
}
package com.ahuaman.recipeapp.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ahuaman.domain.RecipeDomain
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _recipe = MutableStateFlow<RecipeDomain?>(null)
    val recipe = _recipe.asStateFlow()

    init {
        //recipe get
        savedStateHandle.get<String>("recipe")?.let { recipe ->
            Timber.d("recipe: $recipe")
            val recipeDomain = Gson().fromJson(recipe, RecipeDomain::class.java)
            _recipe.value = recipeDomain
        }
    }
}
package com.ahuaman.recipeapp.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ahuaman.recipeapp.R

@Composable
fun EmptyScreen(
    text: String
) {
    CustomStateScreen(
        image = R.drawable.background_empty_state,
        title = stringResource(id = R.string.empty_screen_title_not_found_results),
        description = stringResource(id = R.string.empty_screen_description_no_results, text)
    )
}
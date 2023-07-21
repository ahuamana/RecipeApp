package com.ahuaman.recipeapp.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ahuaman.recipeapp.R

@Composable
fun CustomErrorScreenSomethingHappens(
    modifier: Modifier = Modifier,
){
    CustomStateScreen(
        modifier = modifier,
        title = stringResource(id = R.string.empty_screen_title_error_something_went_wrong),
        //Algo pasó, por favor intenta de nuevo
        description = stringResource(id = R.string.empty_screen_description_error_something_went_wrong),
        image = R.drawable.background_something_wrong
    )
}
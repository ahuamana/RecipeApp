package com.ahuaman.recipeapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ahuaman.domain.RecipeDomain
import com.ahuaman.recipeapp.R
import com.ahuaman.recipeapp.ui.composables.ItemRecipe
import com.ahuaman.recipeapp.ui.theme.RecipeAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onQueryChange: (String) -> Unit,
    listRecipes: List<RecipeDomain>,
) {

    val isDark = isSystemInDarkTheme()

    var searchQuery by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        //Header of the screen
        Box() {
            Card(
                shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp),
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .blur(9.dp)
                        .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))
                        .height(250.dp),
                    painter = painterResource(id = R.drawable.image_background_home),
                    contentDescription = null,
                    contentScale = androidx.compose.ui.layout.ContentScale.Crop
                )
            }

            Column(modifier = Modifier
                .fillMaxWidth()
                .offset(y = 80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.what_do_you_want),
                    color = androidx.compose.ui.graphics.Color.White,
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.googlesans_bold, FontWeight.Bold)),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )

                Text(
                    text = stringResource(R.string.to_cook_today),
                    color = androidx.compose.ui.graphics.Color.White,
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.googlesans_bold, FontWeight.Bold)),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }

            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(70.dp)
                    .offset(y = 200.dp)
                    .clip(RoundedCornerShape(40.dp)),
                query = searchQuery,
                onQueryChange = {  queryChanged ->
                    searchQuery = queryChanged // update the query state
                    onQueryChange(queryChanged) // call the callback
                },
                onSearch = { query ->
                    // Handle search ImeAction.Search here
                },
                active = true,
                onActiveChange = { isActive ->
                },
                placeholder = { Text(stringResource(R.string.search)) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                //trailingIcon = { Icon(Icons.Default.MoreVert, contentDescription = null) }
            ) {
                // Show suggestions here
                // for example a LazyColumn with suggestion items
            }

        }

        //Body of the screen
        Column(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

            Spacer(modifier = Modifier.height(40.dp))

            //Title // popular recipes
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = stringResource(R.string.popular_recipes),
                color = if(isDark) Color.White else Color.Black,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.googlesans_bold, FontWeight.Bold)),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ){
                items(listRecipes) { recipe ->
                    ItemRecipe(model = recipe, onClick = {

                    } )
                }
            }


        }
    }
}

@PreviewScreenSizes
@Preview
@Composable
fun HomeScreenPrev() {
    RecipeAppTheme {

        val listRecipes = listOf(
            RecipeDomain(
                id = "1",
                title = "Recipe 1",
                image = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
                description = "Description 1",
                ingredients = listOf("ingredient1", "ingredient2", "ingredient3"),
                instructions = "Instructions 1",
                tags = listOf("tag1", "tag2", "tag3"),
                score = 1f
            ),
            RecipeDomain(
                id = "2",
                title = "Recipe 2",
                image = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
                description = "Description 2",
                ingredients = listOf("ingredient1", "ingredient2", "ingredient3"),
                instructions = "Instructions 2",
                tags = listOf("tag1", "tag2", "tag3"),
                score = 4.5f
            ),

            RecipeDomain(
                id = "3",
                title = "Recipe 3",
                image = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
                description = "Description 3",
                ingredients = listOf("ingredient1", "ingredient2", "ingredient3"),
                instructions = "Instructions 3",
                tags = listOf("tag1", "tag2", "tag3"),
                score = 3.5f
            ),

            RecipeDomain(
                id = "4",
                title = "Recipe 4",
                image = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
                description = "Description 4",
                ingredients = listOf("ingredient1", "ingredient2", "ingredient3"),
                instructions = "Instructions 4",
                tags = listOf("tag1", "tag2", "tag3"),
                score = 7f
            ),
        )

        HomeScreen(
            listRecipes = listRecipes,
            onQueryChange = {}
        )
    }
}
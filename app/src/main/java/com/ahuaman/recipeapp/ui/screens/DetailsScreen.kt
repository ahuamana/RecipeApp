package com.ahuaman.recipeapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
import com.ahuaman.recipeapp.ui.composables.ItemIngredient
import com.ahuaman.recipeapp.ui.theme.PrimaryColorRecipes
import com.ahuaman.recipeapp.ui.theme.RecipeAppTheme

@Composable
fun DetailsScreen(
    item:RecipeDomain,
    onClickBack: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { onClickBack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        }



        //Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            //title
            Text(
                text = "How to make ${item.title.lowercase()}",
                fontSize = 30.sp,
                fontFamily = FontFamily(Font(R.font.googlesans_bold, FontWeight.Bold)),
            )
            Spacer(modifier = Modifier.height(20.dp))

            //image
            val image = painterResource(id = R.drawable.image_background_intro)

            Card(
                modifier = Modifier.height(200.dp),
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = item.image,
                    contentDescription = item.description,
                    contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                )
            }

            Spacer(modifier = Modifier.height(20.dp))




        }

        //Body
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row() {
                    Card(
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(25.dp),
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp),
                    ) {
                        AsyncImage(
                            model = item.authorImage,
                            contentDescription = item.description,
                            contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.Center,
                    ) {


                        Text(
                            text = item.author?:"",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.googlesans_regular, FontWeight.Normal)),
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Icon(
                                modifier = Modifier
                                    .height(15.dp),
                                painter = painterResource(id = R.drawable.ic_mark_maps),
                                contentDescription = null,
                                tint = PrimaryColorRecipes
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = item.address?:"",
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.googlesans_regular, FontWeight.Normal)),
                            )
                        }
                    }
                }


                //button follow
                Button(
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryColorRecipes,
                    ),
                    onClick = { /*TODO*/ }) {
                    Text(text = "Follow")
                }



            }

            Spacer(modifier = Modifier.height(20.dp))

            //title ingredients
            Text(
                text = "Ingredients",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.googlesans_bold, FontWeight.Bold)),
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ){

                items(item.ingredients.size) { index ->
                    ItemIngredient(name = item.ingredients[index])
                }
            }

        }

        
    }
}

@PreviewFontScale
@PreviewScreenSizes
@Preview
@Composable
fun DetailsScreenPrev() {
    RecipeAppTheme {
        val recipeDomain = RecipeDomain(
            id = "4",
            title = "French Onion Soup",
            image = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
            description = "Description 4",
            ingredients = listOf("ingredient1", "ingredient2", "ingredient3"),
            instructions = "Instructions 4",
            tags = listOf("tag1", "tag2", "tag3"),
            score = 7f,
            author = "Roberta Anny",
            authorImage = "https://www.mockofun.com/wp-content/uploads/2019/12/circle-photo.jpg",
            address = "Bali, Indonesia",
        )


        DetailsScreen(
            item = recipeDomain,
            onClickBack = { }
        )
    }
}
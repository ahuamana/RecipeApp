package com.ahuaman.recipeapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.ahuaman.domain.IngredientDomain
import com.ahuaman.domain.RecipeDomain
import com.ahuaman.recipeapp.R
import com.ahuaman.recipeapp.ui.composables.ItemIngredient
import com.ahuaman.recipeapp.ui.theme.PrimaryColorRecipes
import com.ahuaman.recipeapp.ui.theme.RecipeAppTheme

@Composable
fun DetailsScreen(
    item:RecipeDomain,
    onClickBack: () -> Unit,
    onClickMaps: (RecipeDomain) -> Unit,
) {

    val color = listOf(
        androidx.compose.ui.graphics.Color(0xFFE57373),
        androidx.compose.ui.graphics.Color(0xFFBA68C8),
        androidx.compose.ui.graphics.Color(0xFF64B5F6),
        androidx.compose.ui.graphics.Color(0xFF4DB6AC),
        androidx.compose.ui.graphics.Color(0xFF81C784),
        androidx.compose.ui.graphics.Color(0xFFFFB74D),
        androidx.compose.ui.graphics.Color(0xFFA1887F),
        androidx.compose.ui.graphics.Color(0xFF90A4AE),
    ).random()

    val coloredBackground by remember {
        androidx.compose.runtime.mutableStateOf(color)
    }


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
                Box {
                    AsyncImage(
                        modifier = Modifier.fillMaxWidth(),
                        model = item.image,
                        contentDescription = item.summary,
                        contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                    )

                    //Center Circle with google maps icon
                    Card(
                        shape = androidx.compose.foundation.shape.CircleShape,
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .align(Alignment.Center),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black.copy(alpha = 0.8f)
                        )
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable {
                                           onClickMaps(item)
                                }
                            ,
                            contentAlignment = Alignment.Center) {
                            Icon(
                                modifier = Modifier
                                    .height(15.dp),
                                painter = painterResource(id = R.drawable.ic_mark_maps),
                                contentDescription = null,
                                tint = PrimaryColorRecipes
                            )
                        }

                    }


                }

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
                    //Random color generator

                    Card(
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(25.dp),
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = coloredBackground.copy(alpha = 0.8f)
                        )
                    ) {
                        Box {
                            AsyncImage(
                                model = item.authorImage,
                                contentDescription = item.summary,
                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                            )
                            if(!item.authorImage.isNullOrEmpty()) return@Box
                            val til = item.author?.firstOrNull()?.uppercase()
                            Text(
                                text = til.toString(),
                                fontSize = 20.sp,
                                color = androidx.compose.ui.graphics.Color.White,
                                modifier = Modifier.align(Alignment.Center))
                        }

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

                items(item.extendedIngredients.size) { index ->
                    ItemIngredient(name = item.extendedIngredients[index].name)
                }
            }

        }

        
    }
}

@Preview
@Composable
fun DetailsScreenPrev() {
    RecipeAppTheme {
        val recipeDomain = RecipeDomain(
            id = "4",
            title = "French Onion Soup",
            image = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
            summary = "Description 4",
            extendedIngredients = listOf(
                IngredientDomain(
                    id = "1",
                    name = "Carne",
                    image = "https://www.themealdb.com/images/ingredients/Beef.png"
                ),
                IngredientDomain(
                    id = "2",
                    name = "Tomate",
                    image = "https://www.themealdb.com/images/ingredients/tomato.png"
                ),
                IngredientDomain(
                    id = "3",
                    name = "Cebolla",
                    image = "https://www.themealdb.com/images/ingredients/onions.png"
                ),
            ),
            instructions = "Instructions 4",
            healthScore = 4f,
            author = "Roberta Anny",
            authorImage = "https://www.mockofun.com/wp-content/uploads/2019/12/circle-photo.jpg",
            address = "Bali, Indonesia",
        )


        DetailsScreen(
            item = recipeDomain,
            onClickBack = { },
            onClickMaps = {
                println("Click on maps")
            }
        )
    }
}
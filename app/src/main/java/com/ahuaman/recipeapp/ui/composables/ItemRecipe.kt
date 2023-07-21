package com.ahuaman.recipeapp.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ahuaman.domain.IngredientDomain
import com.ahuaman.domain.RecipeDomain
import com.ahuaman.recipeapp.R
import com.ahuaman.recipeapp.ui.theme.PrimaryColorRecipes

@Composable
fun ItemRecipe(
    model: RecipeDomain,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Card(modifier = Modifier.height(126.dp)) {
            Box() {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = model.image, contentDescription = model.summary,
                    contentScale = androidx.compose.ui.layout.ContentScale.Crop
                )

                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.TopEnd)
                    ,
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(15.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = PrimaryColorRecipes
                    )
                ) {

                    Row(
                        modifier = Modifier.padding(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                     Image(painter = painterResource(id = R.drawable.ic_start), contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = model.healthScore.toString(),
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.googlesans_bold, FontWeight.Bold)),
                        )
                    }
                }

            }

        }
        Spacer(modifier = Modifier.height(8.dp))
        //title
        Text(
            text =  model.title,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.googlesans_bold, FontWeight.Bold)),
        )
        //type
        Text(
            text = model.type ?: "",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.googlesans_bold, FontWeight.Bold)),
        )
    }
}


@Preview
@Composable
fun ItemRecipePrev() {

    val model = RecipeDomain(
        id = "1",
        title = "Banana Pancakes",
        summary = "Cake",
        image = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
        healthScore = 4.5f,
        extendedIngredients = listOf(
            IngredientDomain(
                id = "1",
                name = "Banana",
                image = "https://www.themealdb.com/images/ingredients/Bananas.png"
            ),
        ),
        instructions = "1. Mash bananas in a large bowl until smooth. Mix in eggs and vanilla until well combined, then mix in oats and cinnamon. \n" +
                "2. Heat a skillet to medium and add in a scoop* of the pancake batter. Smooth out to form an even layer. Cook for about 2-3 minutes until you start to see bubbles releasing from the top of the batter. \n" +
                "3. Flip and cook until the other side is golden brown, about 1-2 minutes. Garnish your pancakes with your toppings of choice and enjoy!",
    )

    ItemRecipe(model = model, onClick = { })
}
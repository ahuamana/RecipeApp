package com.ahuaman.recipeapp.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahuaman.recipeapp.R
import com.ahuaman.recipeapp.ui.theme.PrimaryColorRecipes
import com.ahuaman.recipeapp.ui.theme.SecondaryColorRecipes

@Composable
fun ItemIngredient(
    name:String,
) {
    Card(modifier = Modifier
        .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(10.dp),) {
            Icon(
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = null,
                tint = SecondaryColorRecipes
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = name,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.googlesans_regular, FontWeight.Normal)),
            )
        }

    }

}


@Preview
@Composable
fun ItemIngredientPrev() {
    ItemIngredient(
        name = "Milanesa de pollo"
    )
}
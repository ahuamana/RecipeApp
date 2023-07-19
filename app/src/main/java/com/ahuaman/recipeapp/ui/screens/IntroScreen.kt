package com.ahuaman.recipeapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahuaman.recipeapp.R
import com.ahuaman.recipeapp.ui.theme.RecipeAppTheme
import com.ahuaman.recipeapp.ui.theme.YellowPrimary

@Composable
fun IntroScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.image_background_intro),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black.copy(alpha = 0.5f)
        ){}

        //Content in bottom of the screen
        Column(
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxSize(),
        ) {
            val annotatedString = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color.White,
                    fontSize = 50.sp,
                    fontFamily = FontFamily(Font(R.font.googlesans_bold, FontWeight.Bold)),
                    letterSpacing = 10.sp,
                )) {
                    append("Let's")
                }
            }

            val secondAnnotatedString = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color.White,
                    fontSize = 50.sp,
                    fontFamily = FontFamily(Font(R.font.googlesans_bold, FontWeight.Bold)),
                    letterSpacing = 10.sp,

                )) {
                    append("Cooking")
                }
            }


            //Image
            Text(text = annotatedString,)
            Text(text = secondAnnotatedString)


            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Find the best recipes",
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.googlesans_regular, FontWeight.Normal))
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = YellowPrimary,),
                shape = RoundedCornerShape(20),
                onClick = { /*TODO*/ }) {
                Row(
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Start Cooking",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.googlesans_bold, FontWeight.Bold)),
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(painter = painterResource(id = R.drawable.ic_right_arrow), contentDescription = null)
                }
            }
            Spacer(modifier = Modifier.height(60.dp))

        }

    }
}

@Preview
@Composable
fun IntroScreenPrev() {
    RecipeAppTheme() {
        IntroScreen()
    }
}
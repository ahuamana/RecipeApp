package com.ahuaman.recipeapp.ui.screens

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ahuaman.recipeapp.R
import com.ahuaman.recipeapp.ui.theme.PrimaryColorRecipes
import com.ahuaman.recipeapp.ui.theme.RecipeAppTheme
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapsScreen(
    latLng: LatLng = LatLng(1.35, 103.87),
    title : String,
    snippet : String,
) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(latLng, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {

        val iconStart = getBitmapDescriptorFromVector(
            vectorResId = R.drawable.ic_burger
        )

        Marker(
            icon = iconStart,
            state = MarkerState(position = latLng),
            title = title,
            snippet = snippet

        )
    }
}

// Function to convert drawable resource to BitmapDescriptor
@Composable
private fun getBitmapDescriptorFromVector(
    vectorResId: Int,
    @DrawableRes tintColor: Int? = null,
): BitmapDescriptor {
    val drawable: Drawable? = LocalContext.current.getDrawable(vectorResId)

    //tint drawable
    tintColor?.let {
        drawable?.setTint(it)
    }

    val bitmap: Bitmap = drawable?.run {
        val bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth,
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        setBounds(0, 0, canvas.width, canvas.height)
        draw(canvas)
        bitmap
    } ?: throw IllegalArgumentException("Resource not found")

    return BitmapDescriptorFactory.fromBitmap(bitmap)
}

@Preview
@Composable
fun MapsScreenPrev() {
    RecipeAppTheme {
        MapsScreen(
            latLng = LatLng(1.35, 103.87),
            title = "Singapore",
            snippet = "Singapore"
        )
    }
}
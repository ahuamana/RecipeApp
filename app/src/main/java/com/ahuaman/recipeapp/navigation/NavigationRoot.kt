package com.ahuaman.recipeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.ahuaman.domain.RecipeDomain
import com.ahuaman.recipeapp.ui.screens.DetailsScreen
import com.ahuaman.recipeapp.ui.screens.HomeScreen
import com.ahuaman.recipeapp.ui.screens.IntroScreen
import com.ahuaman.recipeapp.ui.screens.MapsScreen

@Composable
fun RootNavigationGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.INTRO
    ){
        composable(route = Graph.INTRO){
            IntroScreen(
                onClickNavigateHome = {
                    navController.navigate(Graph.HOME)
                },
            )
        }

        homeNav(navController = navController)
    }
}

fun NavGraphBuilder.homeNav(navController:NavHostController){
    navigation(
        startDestination = HomeNavigationScreens.HomeScreen.route,
        route = Graph.HOME){

        composable(route = HomeNavigationScreens.HomeScreen.route){
            HomeScreen(
                onQueryChange = {/* TODO */},
                listRecipes = listOf(),
            )
        }

        composable(route = HomeNavigationScreens.DetailScreen.route){
            DetailsScreen(
                item = RecipeDomain(
                    id = "1",
                    title = "Hamburguesa",
                    image = "https://www.recetasderechupete.com/wp-content/uploads/2019/08/Hamburguesa-de-ternera-con-queso-y-cebolla.jpg",
                    ingredients = listOf("Pan", "Carne", "Queso", "Lechuga", "Tomate", "Cebolla"),
                    description = "Hamburguesa de ternera con queso y cebolla",
                    instructions = "1. Cortar la cebolla en juliana y pocharla en una sartén con un poco de aceite de oliva. Salpimentar y reservar.\n" +
                            "2. Dividir la carne en 4 porciones y formar las hamburguesas. Salpimentar.\n" +
                            "3. Calentar una sartén con un poco de aceite de oliva y cocinar las hamburguesas al gusto.\n" +
                            "4. Cortar el pan por la mitad y tostarlo en una sartén con un poco de aceite de oliva.\n" +
                            "5. Montar la hamburguesa con la carne, el queso, la lechuga, el tomate y la cebolla.\n" +
                            "6. Servir con patatas fritas.",
                    tags = listOf("Hamburguesa", "Carne", "Queso", "Lechuga", "Tomate", "Cebolla"),
                    score = 4.5f,
                    author = "Ahuaman",
                ),
                onClickBack = {/* TODO */},
            )
        }

        composable(route = HomeNavigationScreens.MapsScreen.route){
            MapsScreen()
        }
    }
}


sealed class HomeNavigationScreens(val route: String){
    object HomeScreen: HomeNavigationScreens("home")
    object DetailScreen: HomeNavigationScreens("detail")

    object MapsScreen: HomeNavigationScreens("maps")
}

object Graph{
    const val ROOT = "root"
    const val HOME = "home"
    const val INTRO = "intro"
}
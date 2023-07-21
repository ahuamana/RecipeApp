package com.ahuaman.recipeapp.navigation

import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.ahuaman.domain.IngredientDomain
import com.ahuaman.domain.RecipeDomain
import com.ahuaman.recipeapp.ui.screens.DetailsScreen
import com.ahuaman.recipeapp.ui.screens.HomeScreen
import com.ahuaman.recipeapp.ui.screens.IntroScreen
import com.ahuaman.recipeapp.ui.screens.MapsScreen
import com.ahuaman.recipeapp.ui.viewmodel.DetailViewModel
import com.ahuaman.recipeapp.ui.viewmodel.HomeViewModel
import com.ahuaman.recipeapp.ui.viewmodel.MapsViewModel
import com.google.android.gms.maps.model.LatLng
import com.google.gson.Gson
import timber.log.Timber

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
        //nesting navigation
        homeNav(navController = navController)
    }
}

fun NavGraphBuilder.homeNav(navController:NavHostController){
    navigation(
        startDestination = HomeNavigationScreens.HomeScreen.route,
        route = Graph.HOME
    ){

        composable(route = HomeNavigationScreens.HomeScreen.route){
            val homeViewModel = hiltViewModel<HomeViewModel>()
            val listRecipes by homeViewModel.listRecipes.collectAsStateWithLifecycle()

            HomeScreen(
                onQueryChange = {
                                homeViewModel.searchRecipeByIngredients(it)
                                },
                listRecipes = listRecipes,
                onClickRecipe = { recipeDomain ->
                    val bundle =  Bundle()
                    bundle.putString("recipe", Gson().toJson(recipeDomain))
                    navController.navigate(
                        HomeNavigationScreens.DetailScreen.route , args = bundle
                    )
                },
            )
        }

        composable(
            route = HomeNavigationScreens.DetailScreen.route,
        ){
            val viewModel = hiltViewModel<DetailViewModel>()
            val recipe by viewModel.recipe.collectAsStateWithLifecycle()


            recipe?.let { recipeDomain ->
                DetailsScreen(
                    item = recipeDomain,
                    onClickBack = {
                        navController.popBackStack()
                    },
                    onClickMaps = {
                        val bundle =  Bundle()
                        bundle.putString("recipe", Gson().toJson(it))
                        navController.navigate(HomeNavigationScreens.MapsScreen.route, args = bundle)
                    }
                )
            }
        }

        composable(route = HomeNavigationScreens.MapsScreen.route){

            val viewModel = hiltViewModel<MapsViewModel>()
            val recipe by viewModel.recipe.collectAsStateWithLifecycle()

            MapsScreen(
                latLng = LatLng(recipe?.lat?:0.0, recipe?.lon?:0.0),
                title = recipe?.title?:"",
                snippet = recipe?.address?:"",


            )
        }
    }
}


sealed class HomeNavigationScreens(val route: String){
    object HomeScreen: HomeNavigationScreens("home")
    object DetailScreen: HomeNavigationScreens("detail")

    object MapsScreen: HomeNavigationScreens("maps")
}

object Graph{
    const val ROOT = "graph_root"
    const val HOME = "graph_home"
    const val INTRO = "graph_intro"
}
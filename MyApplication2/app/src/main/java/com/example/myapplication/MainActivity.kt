package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import com.example.myapplication.ui.NavigationController
import com.example.myapplication.ui.RecipeDetailsScreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.RecipeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            MyApplicationTheme{
                val recipes: List<Recipe> = listOf(
                    Recipe( image = R.drawable.strawberry_pie_1,
                        title = "Strawberry Cake",
                        category = "Desserts",
                        cookingTime = "50 min",
                        energy = "620 kcal",
                        rating = "4,9",
                        description = "This dessert is very tasty and not difficult to prepare. Also, you can replace strawberries with any other berry you like.",
                        reviews = "84 photos 430 comments",
                        ingredients = listOf(
                            Ingredient(R.drawable.flour, "Flour", "450 g"),
                            Ingredient(R.drawable.eggs, "Eggs", "4"),
                            Ingredient(R.drawable.juice, "Lemon juice", "150 g"),
                            Ingredient(R.drawable.strawberry, "Strawberry", "200 g"),
                            Ingredient(R.drawable.suggar, "Sugar", "1 cup"),
                            Ingredient(R.drawable.mint, "Mint", "20 g"),
                            Ingredient(R.drawable.vanilla, "Vanilla", "1/2 teaspoon"), ) ),
                    Recipe( image = R.drawable.strawberry_pie_1,
                        title = "Strawberry Cake2",
                        category = "Desserts",
                        cookingTime = "50 min",
                        energy = "620 kcal",
                        rating = "4,9",
                        description = "This dessert is very tasty and not difficult to prepare. Also, you can replace strawberries with any other berry you like.",
                        reviews = "84 photos 430 comments",
                        ingredients = listOf( Ingredient(R.drawable.flour, "Flour", "450 g"),
                            Ingredient(R.drawable.eggs, "Eggs", "4"),
                            Ingredient(R.drawable.juice, "Lemon juice", "150 g"),
                            Ingredient(R.drawable.strawberry, "Strawberry", "200 g"),
                            Ingredient(R.drawable.suggar, "Sugar", "1 cup"),
                            Ingredient(R.drawable.mint, "Mint", "20 g"),
                            Ingredient(R.drawable.vanilla, "Vanilla", "1/2 teaspoon"), ) ),
                    Recipe( image = R.drawable.strawberry_pie_1,
                        title = "Strawberry Cake3",
                        category = "Desserts",
                        cookingTime = "50 min",
                        energy = "620 kcal",
                        rating = "4,9",
                        description = "This dessert is very tasty and not difficult to prepare. Also, you can replace strawberries with any other berry you like.",
                        reviews = "84 photos 430 comments",
                        ingredients = listOf( Ingredient(R.drawable.flour, "Flour", "450 g"),
                            Ingredient(R.drawable.eggs, "Eggs", "4"),
                            Ingredient(R.drawable.juice, "Lemon juice", "150 g"),
                            Ingredient(R.drawable.strawberry, "Strawberry", "200 g"),
                            Ingredient(R.drawable.suggar, "Sugar", "1 cup"),
                            Ingredient(R.drawable.mint, "Mint", "20 g"),
                            Ingredient(R.drawable.vanilla, "Vanilla", "1/2 teaspoon"),
                            )
                        )
                )
            NavigationController()
            }
        }
    }
}

data class Recipe(
    @DrawableRes val image: Int,
    var title: String,
    var category: String,
    var cookingTime: String,
    var energy: String,
    var rating: String,
    var description: String,
    var reviews: String,
    var ingredients: List<Ingredient>,
)
data class Ingredient(
    @DrawableRes val image: Int,
    var title: String,
    var subtitle: String
)
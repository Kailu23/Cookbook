@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.myapplication.ui.theme

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.GuardedBy
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.Recipe
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview (showBackground = true)
@Composable
fun RecipeScreen () {
    Column (
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        ScreenTitle(
            title = "What would you like to cook today?",
            subtitle = "Good morning, Marin^2"
        )
        SearchBar(R.drawable.ic_search, "Search")
        RecipeCategories()
        Row (
            modifier = Modifier
                .offset(-130.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically

        ){

                Text(
                    text = "7 recipes",
                    fontSize = 18.sp)
            Image(modifier = Modifier
                .offset(250.dp)
                .size(20.dp),
                painter = painterResource(R.drawable.ic_flame),
                contentDescription = "Nešto",
            )
        }
        RecipeCard(R.drawable.strawberry_pie_1, "Strawberry cake")

        IconButton(R.drawable.ic_plus, "Add new recipe")
    }
}



@Composable
fun ScreenTitle(
    title: String,
    subtitle: String
) {
    Box (
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    )
    {
        Text(
            text = subtitle,
            style = TextStyle(color = Purple500, fontSize = 12.sp, fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic),
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp)
        )
        Text(
            text = title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(vertical = 30.dp, horizontal = 15.dp)
        )
    }
}



@Composable
fun SearchBar(
    @DrawableRes iconResource: Int,
    labelText: String,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent,
        unfocusedPlaceholderColor = DarkGray,
        unfocusedTextColor =  DarkGray,
        focusedTextColor = DarkGray,
        unfocusedLabelColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
    )
)
{
    var searchInput by remember { mutableStateOf("") }
    TextField(
        value = searchInput,
        onValueChange = {searchInput = it },
        label = {
            Text(labelText)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = labelText,
                tint = DarkGray,
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp)
            )
        },
        colors = colors,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun TabButton (
    text: String,
    isActive: Boolean,
    onClick: () -> Unit)
{
    Button(
        shape = RoundedCornerShape(24.dp),
        elevation = null,
        colors = if (isActive) ButtonDefaults.buttonColors(contentColor = White, containerColor = Pink)
        else ButtonDefaults.buttonColors(contentColor = DarkGray, containerColor = LightGray),
        modifier = Modifier.fillMaxHeight(),
        onClick = { onClick() }

    ) { Text(text) }
}

@Composable
fun RecipeCategories() {
    var currentActiveButton by remember { mutableStateOf(0) }
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .height(44.dp)
    ){
        TabButton(text = "All", isActive = currentActiveButton == 0) { currentActiveButton = 0 }
        TabButton(text = "Breakfast", isActive = currentActiveButton == 1) { currentActiveButton = 1 }
        TabButton(text = "Lunch", isActive = currentActiveButton == 2) { currentActiveButton = 2 }
    }
}

@Composable
fun IconButton(
    @DrawableRes iconResource: Int,
    text: String
) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = Pink),
    ) {
        Row {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = text
            )
            Spacer(Modifier.width(2.dp))
            Text( text = text,
                style = TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.Light
                )
            )
        }
    }
}

@Composable
fun Chip(
    text: String,
    backgroundColor: Color = Color.White,
    textColor: Color = Purple500,
    ) {
    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp) )
                .clip(RoundedCornerShape(12.dp))
                .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 12.sp
        )
    }
}

@Composable
fun RecipeCard(
    @DrawableRes imageResource: Int,
    title: String
) {
    Row() {
        Box() {
            Image(
                painter = painterResource(imageResource),
                contentDescription = title,
                modifier = Modifier
//                    .fillMaxSize()
                    .clip(RoundedCornerShape(30))
            )
            Row (
                verticalAlignment = Alignment.Bottom
            ){
            Chip("30 min")
            Chip("4 ingredients")
        }
        }
       Image(
                painter = painterResource(imageResource),
                contentDescription = title,
                modifier = Modifier

//                    .fillMaxSize()
                    .clip(RoundedCornerShape(30))

            )

    }
}


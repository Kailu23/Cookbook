package com.example.myapplication.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.Chip
import com.example.myapplication.ui.theme.White

@Composable
fun RecipeCard(
    @DrawableRes imageResource: Int,
    title: String,
    navigation: NavController,
    recipeId: Int
) {
    Box(
        modifier = Modifier
            .height(326.dp)
            .width(215.dp)
            .clickable { navigation.navigate("recipeDetails/$recipeId") }
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = title,
            modifier = Modifier
                .clip(RoundedCornerShape(20))
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        {
            Text(
                text = title,
                color = White,
                fontSize = (16.sp),
                fontWeight = FontWeight.Bold,
            )
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
            )
            {
                Chip("30 min")
                Chip("4 ingredients")
            }
        }
    }
}
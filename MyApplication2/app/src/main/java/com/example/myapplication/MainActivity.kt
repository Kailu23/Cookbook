package com.example.myapplication

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}

data class Message(
    val author: String, val body: String
)
@Composable
fun MessageCard(msg: Message)
{
    run {
//         Add padding around our message
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(painter = painterResource(R.drawable.profile_picture), contentDescription = "Contact profile picture", modifier = Modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape))

            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = msg.author)
                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = msg.body)
            }
        }
    }
}

data class Recipe(
    @DrawableRes private val image: Int,
    var title: String,
    var category: String,
    var cookingTime: String,
    var energy: String,
    var rating: String,
    var description: String,
    var reviews: String,
    var ingredients: List<String>,
)
data class Ingredients(
    @DrawableRes private val image: Int,
    var title: String,
    var subtitle: String
)
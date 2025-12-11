package com.example.socialmediaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.concurrent.BlockingDeque

data class Discussion(
    val profile: Int,
    val isActive: Boolean,
    val name: String,
    val message: String,
    val hour: String,
    val isRead: Boolean

)

@Composable
fun DiscussionUI(name: String, message: String, hour: String, isRead: Boolean ,isActive: Boolean, profile : Int)//Img : Composable
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxHeight()) {
            Image(
                painter = painterResource(profile),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(50))
            )
            if (isActive==true)
            Box(
                modifier = Modifier
                    .padding(top = 35.dp)
                    .size(20.dp)
                    .clip(shape = RoundedCornerShape(50))
                    .background(Color.Green)
                    .align(Alignment.CenterEnd)

            )

        }
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier

                    .fillMaxHeight()
                    .weight(1f)
            ) {
                Text(
                    name,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.labelLarge
                )
                Spacer( modifier = Modifier.height(7.25.dp))
                Text(
                    message,
                    style = MaterialTheme.typography.bodyLarge ,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = Color.Gray
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxHeight().padding(end = 10.dp)
            ) {

                if (isRead == false) {
                    Text(hour, color = green , fontSize = 12.sp)
                    Spacer( modifier = Modifier.height(7.25.dp))
                    Box(modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(50))
                        .background(green),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("10", color =White)
                    }


                } else {
                    Text(hour, fontSize = 12.sp)

                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DiscussionUIPreview() {
    DiscussionUI("Etienne Delhy", "Hello Guys !", "11 : 30", false , true,R.drawable.itachi)
}
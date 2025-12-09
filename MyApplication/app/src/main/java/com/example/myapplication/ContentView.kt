package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContentBar ()
{
    Column(horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(color = MyMarron).fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.to_do_list),
            contentDescription = "Welcome Menu",

        )
        Spacer( modifier = Modifier.height(45.dp))
        Text(
            text = "There is no Task on this page",
            fontSize = 20.sp ,
            fontWeight = FontWeight.Bold,
            color = Color.Black

        )
        Spacer( modifier = Modifier.height(10.dp))

        Text(
            text = "You don't have a missin right Now. You can \ncreate a mission right now and get started",
            fontSize = 17.5.sp,
            color = Color.Black
        )
    }

}

@Preview( showBackground = true)
@Composable
fun ContentBarPreview()
{
    ContentBar()
}
package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val MyWhite = Color(255, 255, 255, 255)
val MyBlue = Color(0, 119, 105, 255)
val MyMarron = Color(255, 246, 241, 255)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topbar ()
{
    TopAppBar(
        title = {
            Row( verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource( R.drawable.cute_anime),
                    contentDescription = "Cute Profile",
                    modifier = Modifier.size(45.dp)
                        .clip(shape = RoundedCornerShape(50))
                )
                Column {
                    Text(
                        text = "Gabriel Ngoh",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Software Engineer",
                        fontSize = 17.sp

                        )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors( actionIconContentColor = MyBlue , containerColor =MyWhite ),
        actions = {
            Row( verticalAlignment = Alignment.CenterVertically) {
               IconButton( onClick = {} ) {
                   Icon(
                       Icons.Default.Add,"Add Task Icon"
                   )
               }
                Text( text = "New Task", color= MyBlue)
            }

        }
    )
}

@Preview
@Composable
fun TopBarPreview()
{
    Topbar()
}
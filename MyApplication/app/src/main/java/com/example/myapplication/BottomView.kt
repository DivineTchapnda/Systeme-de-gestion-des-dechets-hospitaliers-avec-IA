package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar ()
{
    BottomAppBar( containerColor = MyMarron , contentColor = Color.DarkGray , contentPadding = BottomAppBarDefaults.ContentPadding , ) {
        Row( horizontalArrangement = Arrangement.SpaceAround , modifier = Modifier.fillMaxWidth()) {

            Column() {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.CheckCircle,
                        contentDescription = ""

                    )
                }
                Text(text = "Tasks")

            }
            Column() {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.Face,
                        contentDescription = ""

                    )
                }
                Text(text = "My Day")

            }
            Column() {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.DateRange,
                        contentDescription = ""

                    )
                }
                Text(text = "Planned")

            }
            Column() {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = ""

                    )
                }
                Text(text = "Important")

            }


        }



    }
}

@Preview
@Composable
fun BottomBarPreview()
{
    BottomBar()

}
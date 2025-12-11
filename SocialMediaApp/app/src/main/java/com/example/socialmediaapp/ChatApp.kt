package com.example.socialmediaapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialmediaapp.ui.theme.GabyAppTypography
import com.example.socialmediaapp.ui.theme.Transparent


val list = listOf<Discussion>(
    Discussion(R.drawable.itachi, true, "Darell Steward", "Hello , Good Morning!", "11:47 PM", false),
    Discussion(R.drawable.girl2, true, "Jane Cooper", "You : Can you sent the photo ?", "11:23 PM", true),
    Discussion(R.drawable.girl1, false, "Theresa Webb", "Okay . Thank You", "11:17 PM", false),
    Discussion(R.drawable.team, true, "Jane Coopen", "Hello Dude !", "11:23 PM", true),
    Discussion(R.drawable.girl4, false, "Work Team", "Wait , i'm om my way !", "08:27 PM", true),
    Discussion(R.drawable.man27, true, "Annette Black", "You : Okay Rin , sounds good. Let's", "08:13 PM", true),
    Discussion(R.drawable.killua, false, "Ronald Richards", "You : Can you sent the photo ?", "Yesterday", true),
    Discussion(R.drawable.boy3, false, "Guy Hawkins", "Wait , i'm om my way !", "Yesterdday", true),
    )
val green = Color(0xFF25D366)
val White = Color.White
val borderSearch= Color(255, 255, 255, 90)
val Gray = Color(0xFF525752)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatApp()
{
    Scaffold(
        topBar = {
            Column() {
                TopAppBar(
                    {
                        Text(
                            "GabApp",
                            style = MaterialTheme.typography.titleLarge
                        )

                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = green)
                )
                Row(
                    modifier = Modifier
                        .background(green)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    OutlinedTextField(
                        shape = RoundedCornerShape(20),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp, 5.dp, 10.dp, 15.dp),
                        maxLines = 1,
                        value = "Search Chat , person and more...",
                        onValueChange = {},
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Transparent,
                            unfocusedTextColor =White,
                            unfocusedBorderColor = borderSearch
                        ),
                        leadingIcon = {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color.White
                            )
                        })

                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                shape = RoundedCornerShape(50),
                containerColor = green,
                contentColor = White
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Add"
                )
            }
        },
        bottomBar = {
            BottomAppBar(containerColor =green, contentColor = Gray) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.Call,
                                contentDescription = "call"
                            )

                        }
                        Text("Call", fontSize = 13.sp)
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.MailOutline,
                                contentDescription = "Message"
                            )

                        }
                        Text("Message", fontSize = 13.sp)
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.Settings,
                                contentDescription = "setting"
                            )

                        }
                        Text("Setting", fontSize = 13.sp)
                    }
                }


            }
        }) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(list) { it ->
                DiscussionUI( it.name, it.message, it.hour, it.isRead ,it.isActive,it.profile )
            }

        }
    }

}
package com.example.todolistapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayTaskScreen(navController: NavController) {
    var tasks = remember { mutableStateListOf<Pair<String , Task>>() }
    LaunchedEffect(Unit) {
        Repository.getTask {
            list->
            tasks.clear()
            tasks.addAll(list)
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mes Taches") },

                colors = TopAppBarDefaults.topAppBarColors(titleContentColor = Color(0 , 0 , 0 )),

            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("add") })
            {
                Icon(Icons.Default.Add, contentDescription = "Plus")
            }
        }
    )
    { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()) {
            LazyColumn() {
                items(tasks) { (id ,task) ->
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                            .fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(5.dp),
                        shape = RoundedCornerShape(12.dp),



                    ) {
                        Box(modifier = Modifier.fillMaxWidth()) {
                            var isChecked by rememberSaveable { mutableStateOf(false) }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                val myCyan = Color(0xFF00FFFF)
                                Checkbox(
                                    modifier = Modifier.size(50.dp).clip(shape = RoundedCornerShape(50)),
                                    onCheckedChange = {
                                        isChecked = !isChecked

                                    },
                                    checked = isChecked,
                                    colors = CheckboxDefaults.colors(
                                        uncheckedColor = myCyan,
                                        checkedColor = Color.Green
                                    )
                                )
                                Text(text = task.name)
                                Icon(
                                    Icons.Default.Delete,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .clickable(onClick = { Repository.deleteTask(id) })
                                )
                            }

                        }


                    }
                }
            }
        }

    }

}



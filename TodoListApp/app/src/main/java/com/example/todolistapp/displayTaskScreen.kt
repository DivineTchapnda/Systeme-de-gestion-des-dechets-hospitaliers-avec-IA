package com.example.todolistapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material3.MaterialTheme
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
    val today = remember {
        val calc =java.util.Calendar.getInstance()
        calc.set(
            calc.get(java.util.Calendar.YEAR),
            calc.get(java.util.Calendar.MONTH),
            calc.get(java.util.Calendar.DAY_OF_MONTH),
            0,0,0,
        )
        calc.timeInMillis
    }
    var tasks = remember { mutableStateListOf<Pair<String , Task>>() }
    LaunchedEffect(Unit) {
        Repository.getTask {
            list->
            tasks.clear()
            tasks.addAll(list)
        }
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("add") },
                containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = Color.Black)
            {
                Icon(Icons.Default.Add, contentDescription = "Plus")
            }
        }
    )
    { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            DisplayDateToday()
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn() {
                items(tasks) { (id, task) ->
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                            .fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(5.dp),
                        shape = RoundedCornerShape(12.dp),


                        ) {
                            CardTask(id , task)
                    }
                }
            }

        }
    }

}



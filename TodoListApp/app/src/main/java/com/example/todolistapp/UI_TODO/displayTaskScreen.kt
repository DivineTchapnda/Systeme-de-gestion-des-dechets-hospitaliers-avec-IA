package com.example.todolistapp.UI_TODO

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.todolistapp.Data.Repository
import com.example.todolistapp.Data.Task
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayTaskScreen(navController: NavController) {
    val today = remember {
        val calc = Calendar.getInstance()
        calc.set(
            calc.get(Calendar.YEAR),
            calc.get(Calendar.MONTH),
            calc.get(Calendar.DAY_OF_MONTH),
            0, 0, 0,
        )
        calc.timeInMillis
    }
    val tasks = remember { mutableStateListOf<Pair<String, Task>>() }
    LaunchedEffect(Unit) {
        Repository.getTask { list ->
            tasks.clear()
            tasks.addAll(list)
        }
    }
    Scaffold(

        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add") },
                containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = Color.Black
            )
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

            if (tasks.isEmpty()) {
                EmptyTaskScreen(
                )
            } else {
                TaskListScreen(
                    tasks = tasks,
                )
            }

        }
    }

}



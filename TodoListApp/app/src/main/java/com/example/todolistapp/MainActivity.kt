package com.example.todolistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolistapp.ui.theme.TodoListAppTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        enableEdgeToEdge()
        setContent {

            TodoListApp()
        }

    }
}

@Composable
fun TodoListApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "display")
    {
        composable("display") {
            DisplayTaskScreen(navController)
        }
        composable("add") {
            AddTaskScreen(navController)
        }
    }
}


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Preview() {

    TodoListApp()
}
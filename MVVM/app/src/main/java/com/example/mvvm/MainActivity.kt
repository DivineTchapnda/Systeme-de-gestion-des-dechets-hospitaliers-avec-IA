package com.example.mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvvm.ui.theme.MVVMTheme
import com.example.mvvm.viewmodel.TodoViewModel
import com.example.mvvm.view.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = TodoViewModel()
            HomeScreen(viewModel)
        }
    }
}



@Preview(showBackground = true , showSystemUi = true)
@Composable
fun TodoPreview() {
    val viewModel = TodoViewModel()
    HomeScreen(viewModel)
}
package com.example.learningstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningstate.ui.theme.LearningStateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningStateTheme {

                    RegisterFormView(Modifier.padding(15.dp) )

            }
        }
    }
}



@Preview(showBackground = true , showSystemUi = true)
@Composable
fun GreetingPreview() {
    LearningStateTheme {

            RegisterFormView(Modifier.fillMaxSize().padding(15.dp) )


    }
}
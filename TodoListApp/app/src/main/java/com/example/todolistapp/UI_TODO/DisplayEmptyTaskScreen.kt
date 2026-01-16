package com.example.todolistapp.UI_TODO

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolistapp.R

@Composable
fun EmptyTaskScreen() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Mes tâches", color = Color.White, fontSize = 30.sp)
        Spacer(modifier = Modifier.height(40.dp))

        Image(
            painter = painterResource(id = R.drawable.relax),
            contentDescription = "Aucune tâche",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
        )

        Spacer(modifier = Modifier.height(45.dp))

        Text(
            text = "Aucune tâche pour le moment",
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Commencez par ajouter une nouvelle tâche",
            fontSize = 20.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}
